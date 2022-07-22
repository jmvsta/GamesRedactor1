package me.jmvsta.service

import com.corundumstudio.socketio.AckRequest
import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIOServer
import me.jmvsta.data.ChatObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy


@Service(value = "socketIOService")
class SocketIOServiceImpl : SocketIOService {

    @Autowired
    private lateinit var socketIOServer: SocketIOServer

    @PostConstruct
    @Throws(Exception::class)
    private fun autoStartup() {
        start()
    }

    @PreDestroy
    @Throws(Exception::class)
    private fun autoStop() {
        stop()
    }

    override fun start() {
        socketIOServer.addConnectListener { client: SocketIOClient ->
            val loginUserNum = getParamsByClient(client)
            if (loginUserNum != null) {
                clientMap[loginUserNum] = client
            }
        }

        socketIOServer.addDisconnectListener { client: SocketIOClient ->
            val loginUserNum = getParamsByClient(client)
            clientMap.remove(loginUserNum)
            client.disconnect()
        }

//        val chat2namespace = socketIOServer.addNamespace("/chat2")
        socketIOServer.addEventListener(
            SocketIOService.PUSH_EVENT,
            ChatObject::class.java
        ) { _: SocketIOClient?, data: ChatObject, _: AckRequest? ->
            socketIOServer.broadcastOperations.sendEvent(SocketIOService.PUSH_EVENT, data)
        }
        socketIOServer.start()
    }

    override fun stop() {
        socketIOServer.stop()
    }

    override fun pushMessageToUser(pushMessage: ChatObject) {
        val userName = pushMessage.userName
        userName?.let {
            val client = clientMap[userName]
            client?.sendEvent(SocketIOService.PUSH_EVENT, pushMessage)
        }
    }

    private fun getParamsByClient(client: SocketIOClient): String? {
        val params = client.handshakeData.urlParams
        val list = params["userName"]
        return list?.get(0)
    }

    companion object {
        private val clientMap: MutableMap<String, SocketIOClient> = ConcurrentHashMap()
    }
}