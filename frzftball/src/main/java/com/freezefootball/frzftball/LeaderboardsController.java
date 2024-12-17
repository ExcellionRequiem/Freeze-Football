package com.freezefootball.frzftball;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/leaderboards")
public class LeaderboardsController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping
    public ResponseEntity<List<LeaderboardEntry>> getLeaderboards() {
        List<LeaderboardEntry> leaderboards = leaderboardService.loadLeaderboardFromFile();
        return new ResponseEntity<>(leaderboards, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateLeaderboards(HttpSession session, @RequestBody LeaderboardEntry entry){

        String username = (String) session.getAttribute("username");
        if(username==null){
            return ResponseEntity.badRequest().body("For some reason, user is not logged in");
        }       
        leaderboardService.updateLeaderboards(username, entry);
        return new ResponseEntity<>("Leaderboards updated", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteLeaderboardEntry(HttpSession session){
        String username = (String) session.getAttribute("username");

        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User, somehow, isn't logged in?");
        }
        
        leaderboardService.deleteUserStats(username);
        return new ResponseEntity<>("User statistics deleted from leaderboards", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addLeaderboardEntry(@RequestBody LeaderboardEntry entry) {
        
        leaderboardService.addNewUser(entry);
        
        return new ResponseEntity<>("User statistics registered to learboards", HttpStatus.OK);
    }
    
    

}
