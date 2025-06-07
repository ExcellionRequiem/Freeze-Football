package com.freezefootball.frzftball;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.Message;

@Controller
public class MatchMakingController {

    @Autowired
    private SimpMessagingTemplate msgtmplt;

    //La lista de espera
    private final List<String> waitingPlayers = new ArrayList<>();

    @MessageMapping("/readyGetUser")
    public void GetUser(Message<?> msg){

        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(msg);
        String username = (String) headers.getSessionAttributes().get("username");
        if (username != null) {

            //Le metemos en lista de espera
            System.out.println("Jugador listo: " + username);
            
            if (!waitingPlayers.contains(username)) {
                waitingPlayers.add(username);
            }
            
            // Solo mandar "Esperando rival..." si aún está en espera
            if (waitingPlayers.size() < 2) {
                msgtmplt.convertAndSend("/client/match/" + username, "Esperando rival...");
            }

            //(Asumiendo que hay más de 1 jugador en espera)
            while (waitingPlayers.size() >= 2) {
                String player1 = waitingPlayers.remove(0);
                String player2 = waitingPlayers.remove(0);

                //Envia los nombres del otro a cada jugador
                msgtmplt.convertAndSend("/client/match/" + player1, player2);
                msgtmplt.convertAndSend("/client/match/" + player2, player1);
            } 
        }

    }

}
