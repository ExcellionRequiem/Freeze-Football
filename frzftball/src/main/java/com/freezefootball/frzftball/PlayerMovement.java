package com.freezefootball.frzftball;

public class PlayerMovement {

    public PlayerMovement() {}

    public String type;
    public String from;
    public Position position;
    public Boot boot;

    public String getType(){ return type; }
    public String getFrom(){ return from; }
    public Position getPosition(){ return position; }
    public Boot getBoot(){ return boot; }

    public void setType(String type) { this.type = type; }
    public void setFrom(String from) { this.from = from; }
    public void setPosition(Position position) { this.position = position; }
    public void setBoot(Boot boot) { this.boot = boot; }

    public static class Position {

        public Position() {}

        public float x, y, vx, vy;
        public float getX(){ return x; }
        public float getY(){ return y; }
        public float getVX(){ return vx; }
        public float getVY(){ return vy; }

        public void setX(float x) { this.x = x; }
        public void setY(float y) { this.y = y; }
        public void setVX(float vx) { this.vx = vx; }
        public void setVY(float vy) { this.vy = vy; }

    }

    public static class Boot {

        public Boot() {}

        public float x, y, vx, vy;
        public float getX(){ return x; }
        public float getY(){ return y; }
        public float getVX(){ return vx; }
        public float getVY(){ return vy; }

        public void setX(float x) { this.x = x; }
        public void setY(float y) { this.y = y; }
        public void setVX(float vx) { this.vx = vx; }
        public void setVY(float vy) { this.vy = vy; }
    }
}