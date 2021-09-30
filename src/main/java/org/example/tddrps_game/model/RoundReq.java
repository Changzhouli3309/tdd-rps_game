package org.example.tddrps_game.model;

public class RoundReq {
    private String playerMove;
    private String message;

    public RoundReq(String playerMove, String message) {
        this.playerMove = playerMove;
        this.message = message;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
