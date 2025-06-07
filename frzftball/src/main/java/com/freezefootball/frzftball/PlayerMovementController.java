package com.freezefootball.frzftball;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerMovementController {
    @MessageMapping("/movement")
    @SendTo("/client/movement")
    public PlayerMovement handleMove(PlayerMovement movement) {
        return movement;
    }
}
