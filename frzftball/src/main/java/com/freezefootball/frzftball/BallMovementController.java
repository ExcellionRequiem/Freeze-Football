package com.freezefootball.frzftball;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class BallMovementController {

    @MessageMapping("/ballSync")
    @SendTo("/client/ballSync")
    public BallData handleMove(BallData ballSync) {
        System.out.println("Pelota sincronizada por: " + ballSync.getFrom());
        return ballSync;
    }
}
