package com.freezefootball.frzftball;

public class BallData {

    public BallData() {}

    private float x;
    private float y;
    private float vx;
    private float vy;

    private String from;

    // Getters
    public float getX() { return x; }
    public float getY() { return y; }
    public float getVx() { return vx; }
    public float getVy() { return vy; }

    public String getFrom() { return from; }

    // Setters
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    public void setVx(float vx) { this.vx = vx; }
    public void setVy(float vy) { this.vy = vy; }
    
    public void setFrom(String from) { this.from = from; }
}

