package com.freezefootball.frzftball;

public class ChatMessage {
    private String username;
    private String message;
    private long timestamp;

    public ChatMessage() {}

    public ChatMessage(String username, String message, long timestamp) {
        this.username = username;
        this.message = message;
        this.timestamp = timestamp;
    }

    public void setPlayer(String message) {
        this.username = message;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
