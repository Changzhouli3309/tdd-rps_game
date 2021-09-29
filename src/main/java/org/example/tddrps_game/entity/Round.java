package org.example.tddrps_game.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Round {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String playerMove, aiMove, result;

    public Round() {
        //jpa
    }

    public Round(String playerMove, String aiMove, String result) {
        this.playerMove = playerMove;
        this.aiMove = aiMove;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

    public String getAiMove() {
        return aiMove;
    }

    public void setAiMove(String aiMove) {
        this.aiMove = aiMove;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", playerMove='" + playerMove + '\'' +
                ", aiMove='" + aiMove + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}