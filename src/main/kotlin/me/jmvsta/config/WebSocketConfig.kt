package me.jmvsta.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessageType
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
import java.io.IOException


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig: WebSocketMessageBrokerConfigurer {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/mywebsockets")
            .setAllowedOrigins("*")
            .withSockJS()
    }

    override fun configureMessageBroker(config: MessageBrokerRegistry){
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app", "/user");
    }
}

//@Configuration
//class WebSocketSecurityConfig : AbstractSecurityWebSocketMessageBrokerConfigurer() {
//    protected fun configureInbound(messages: MessageSecurityMetadataSourceRegistry) {
//        messages
//            .simpTypeMatchers(
//                SimpMessageType.CONNECT,
//                SimpMessageType.HEARTBEAT,
//                SimpMessageType.UNSUBSCRIBE,
//                SimpMessageType.DISCONNECT
//            ).permitAll()
//            .simpDestMatchers("/user/**").authenticated()
//            .simpSubscribeDestMatchers("/user/**").authenticated()
//    }
//
//    protected fun sameOriginDisabled(): Boolean {
//        return true
//    }
//}
