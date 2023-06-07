package team.spring.runup.chatMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	Logger log = LogManager.getLogger("case3");
	
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	log.debug("소켓경로 설정");
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	log.debug("cors 설정");
        registry.addEndpoint("websocket-chat")
//                .setAllowedOrigins("*") // 도메인을 구체적으로 명시
                .setAllowedOriginPatterns("*") // 또는 이렇게 패턴을 사용할 수 있다.
                .withSockJS();
    }
}
