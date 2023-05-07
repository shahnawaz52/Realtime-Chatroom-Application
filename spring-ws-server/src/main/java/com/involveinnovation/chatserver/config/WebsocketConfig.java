package com.involveinnovation.chatserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    @java.lang.Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        set destination prefixes where user send data
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/chatroom", "/user");
        registry.setUserDestinationPrefix("/user");
    }

    @java.lang.Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        stomp endpoint
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS(); //socket configuration
    }
}
