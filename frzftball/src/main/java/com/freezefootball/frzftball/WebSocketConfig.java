package com.freezefootball.frzftball;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/client"); //direccion clientes
        config.setApplicationDestinationPrefixes("/server"); //direccion servidor
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setHandshakeHandler(new DefaultHandshakeHandler() {
            public boolean beforeHandshake(
                ServerHttpRequest request,
                ServerHttpResponse response,    
                WebSocketHandler wsHandler,
                Map<String, Object> attributes) throws Exception {
                    
                    //Esto es magia negra para guardar el atributo username en el socket tambien
                    if (request instanceof ServletServerHttpRequest servletRequest) {
                        HttpSession session = servletRequest.getServletRequest().getSession(false);
                        if (session != null) {
                            String username = (String) session.getAttribute("username");
                            System.out.println("Handshake: session username = " + username);
                            if (username != null) {
                                attributes.put("username", username);
                            }
                        }
                    }
                    return true;
                }
        })
        .setAllowedOriginPatterns("*")
        .withSockJS();
    }
    
}