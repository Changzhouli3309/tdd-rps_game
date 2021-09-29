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

    @ElementCollection(fetch = FetchType.EAGER)
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
    @JoinColumn(name = "Game_id")
    private List<Round> rounds;

    public Game() {
        //jpa
    }

    public Game(int scoreLimit) {
        this.scoreLimit = scoreLimit;
        this.win = 0;
        this.loss = 0;
        this.rounds = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", scoreLimit=" + scoreLimit +
                ", win=" + win +
                ", loss=" + loss +
                ", rounds=" + rounds +
                '}';
    }
}
