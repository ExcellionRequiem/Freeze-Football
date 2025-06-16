package com.freezefootball.frzftball;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.http.HttpSession;

public class HttpHandshakeInterceptor implements HandshakeInterceptor{
    
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                    WebSocketHandler wsHandler, Map attributes) throws Exception {

        if (request instanceof ServletServerHttpRequest) {

            // Esto es magia negra para guardar el atributo username en el socket tambien

            if (request instanceof ServletServerHttpRequest servletRequest) {

                HttpSession session = servletRequest.getServletRequest().getSession(false);

                if (session != null) {

                    String username = (String) session.getAttribute("username");

                    if (username != null) {

                        attributes.put("username", username);

                    }

                }

            }

            return true;

        }

        return true;

    }

 

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,Exception exception) {

        throw new UnsupportedOperationException("Unimplemented method 'afterHandshake'");

    }

}
