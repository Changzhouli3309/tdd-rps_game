package org.example.tddrps_game.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private int scoreLimit, win, loss;

    @ElementCollection
    @JoinColumn(name = "Rid")
    private List<Round> rounds = new ArrayList<>();

    public Game() {
        //jpa
    }

    public Game(int scoreLimit) {
        this.scoreLimit = scoreLimit;
        this.win = 0;
        this.loss = 0;
    }

    public Long getId() {
        return id;
    }

    public int getScoreLimit() {
        return scoreLimit;
    }

    public void setScoreLimit(int scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
