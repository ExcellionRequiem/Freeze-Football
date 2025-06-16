package com.freezefootball.frzftball;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerMovementController {

    @MessageMapping("/movement/{username}")
    @SendTo("/client/movement/{username}")
    public PlayerMovement handleMove(@DestinationVariable String username, PlayerMovement movement) {
        System.out.println("Movimiento recibido de: " + username);
        return movement;
    }
}
