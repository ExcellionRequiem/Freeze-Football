package com.freezefootball.frzftball;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LeaderboardService {
    
    private final String _filePath = "leaderboard.json";
    private List<LeaderboardEntry> leaderboards = new ArrayList<>();

    public LeaderboardService(){
        loadLeaderboardFromFile();
    }

    public List<LeaderboardEntry> loadLeaderboardFromFile(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            File savedLeaderboards = new File(_filePath);
            if(savedLeaderboards.exists()){
                leaderboards = new ArrayList<>(Arrays.asList(mapper.readValue(savedLeaderboards, LeaderboardEntry[].class)));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return leaderboards; 
    }

    public void saveLeaderboardsToFile(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(_filePath), leaderboards);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addNewUser(LeaderboardEntry entry){
        leaderboards.add(entry);
        saveLeaderboardsToFile();
    }

    public void updateLeaderboards(String username, LeaderboardEntry updatedEntry){
        for (LeaderboardEntry entry : leaderboards) {
            if (entry.getUsername().equals(username)) {
                entry.setScore(entry.getScore()+updatedEntry.getScore());
                entry.setWins(entry.getWins()+updatedEntry.getWins());
                saveLeaderboardsToFile();
                return;
            }
        }
        addNewUser(updatedEntry);
    }

    public void deleteUserStats(String username){
        leaderboards.removeIf(entry->entry.getUsername().equals(username));
        saveLeaderboardsToFile();
    }

}
