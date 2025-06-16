package com.freezefootball.frzftball;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class BallMovementController {

    @MessageMapping("/ballSync/{username}")
    @SendTo("/client/ballSync/{username}")
    public BallData handleMove(@DestinationVariable String username, BallData ballSync) {
        System.out.println("Pelota sincronizada por: " + username);
        return ballSync;
    }
}
