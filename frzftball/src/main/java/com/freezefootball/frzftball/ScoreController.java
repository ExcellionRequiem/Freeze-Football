package com.freezefootball.frzftball;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ScoreController {

    @MessageMapping("/score")
    @SendTo("/client/score")
    public ScoreMarker handleScore(ScoreMarker score) {
        System.out.println("Puntuacion recibida de : " + score.getFrom());
        return score;
    }
}
