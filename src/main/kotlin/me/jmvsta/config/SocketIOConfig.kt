package me.jmvsta.config

import com.corundumstudio.socketio.SocketConfig
import com.corundumstudio.socketio.SocketIOServer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SocketIOConfig {

    @Value("\${socketio.host}")
    private lateinit var host: String

    @Value("\${socketio.port}")
    private lateinit var port: String

//    @Value("\${socketio.bossCount}")
//    private lateinit var bossCount: String
//
//    @Value("\${socketio.workCount}")
//    private lateinit var workCount: String
//
//    @Value("\${socketio.allowCustomRequests}")
//    private lateinit var allowCustomRequests: String
//
//    @Value("\${socketio.upgradeTimeout}")
//    private lateinit var upgradeTimeout: String
//
//    @Value("\${socketio.pingTimeout}")
//    private lateinit var pingTimeout: String
//
//    @Value("\${socketio.pingInterval}")
//    private lateinit var pingInterval: String

    @Bean
    fun socketIOServer(): SocketIOServer {
        val socketConfig = SocketConfig()
        socketConfig.isTcpNoDelay = true
        socketConfig.soLinger = 0
        val config = com.corundumstudio.socketio.Configuration()
        config.socketConfig = socketConfig
        config.hostname = host
        config.port = port.toInt()
//        config.bossThreads = bossCount.toInt()
//        config.workerThreads = workCount.toInt()
//        config.isAllowCustomRequests = allowCustomRequests.toBoolean()
//        config.upgradeTimeout = upgradeTimeout.toInt()
//        config.pingTimeout = pingTimeout.toInt()
//        config.pingInterval = pingInterval.toInt()
        return SocketIOServer(config)
    }
}