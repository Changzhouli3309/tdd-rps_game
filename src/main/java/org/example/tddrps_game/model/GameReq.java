package org.example.tddrps_game.model;

public class GameReq {
    private int scoreLimit;
    private String message;

    public GameReq(int scoreLimit, String message) {
        this.scoreLimit = scoreLimit;
        this.message = message;
    }

    public void setScoreLimit(int scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

    public int getScoreLimit() {
        return scoreLimit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
