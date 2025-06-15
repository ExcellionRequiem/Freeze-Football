package com.freezefootball.frzftball;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ScoreController {

    @MessageMapping("/score/{username}")
    @SendTo("/client/score/{username}")
    public ScoreMarker handleScore(@DestinationVariable String username, ScoreMarker score) {
        System.out.println("Puntuacion recibida de : " + username);
        return score;
    }
}