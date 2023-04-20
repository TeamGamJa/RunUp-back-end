//package team.spring.runup.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry config) {
////		WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
//		config.enableSimpleBroker("/send");
//	}
//	
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {
////		WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
//		registry.addEndpoint("/").setAllowedOriginPatterns("http://localhost:8081").withSockJS();
//	}
//}
