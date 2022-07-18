package me.jmvsta.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.annotation.SendToUser
import org.springframework.stereotype.Controller
import java.io.IOException

@Controller
class GameStateController

@Autowired private lateinit var simpleMessagingTemplate: SimpMessagingTemplate

@MessageMapping("/messages")
@Throws(IOException::class)
fun sendUserMsg(messages: String) {
    println("webSocket:$messages")
    simpleMessagingTemplate.convertAndSend("/queue/position-updates", "This is return message")
}

@MessageMapping("/user/info")
@SendToUser(value = ["/queue/userInfo"], broadcast = false)
fun userInfo(): String {
//    log.info("push user info"：passUser={}", JsonUtil.toJsonString(passUser));
    return "TEST2USER"
}


//@MessageMapping("/user/info")
//@SendToUser(value = ["/queue/userInfo"], broadcast = false)
//fun userInfo(@AuthenticationPrincipal PassUser passUser): String {
////    log.info("push user info"：passUser={}", JsonUtil.toJsonString(passUser));
//    return JsonUtil.toJsonString(passUser);
//}
