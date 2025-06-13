package com.freezefootball.frzftball;

public class LeaderboardEntry {

    private String username;
    private int score;
    private int wins;

    public String getUsername(){
        return username;
    }

    public int getScore(){
        return score;
    }

    public int getWins(){
        return wins;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setScore(int score){
        this.score=score;
    }

    public void setWins(int wins){
        this.wins=wins;
    }

}
