package com.freezefootball.frzftball;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final List<ChatMessage> messages = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody ChatMessage chatMessage, HttpSession session) {
        String username = chatMessage.getUsername();
    
        if (username == null || username.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    
        // Acoplar el nombre de usuario al mensaje
        chatMessage.setMessage(username + ": " + chatMessage.getMessage());
        chatMessage.setTimestamp(System.currentTimeMillis());
    
        synchronized (messages) {
            messages.add(chatMessage);
            if (messages.size() > 25) { // Limitar a 25 mensajes
                messages.remove(0);
            }
        }
    
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ChatMessage> getMessages(@RequestParam(defaultValue = "0") long since) {
        synchronized (messages) {
            return messages.stream()
                    .filter(msg -> msg.getTimestamp() > since)
                    .collect(Collectors.toList());
        }
    }
}
