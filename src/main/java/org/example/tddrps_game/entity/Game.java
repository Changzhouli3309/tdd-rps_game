package org.example.tddrps_game.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Game {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private int id;
    private int scoreLimit, win, lose;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "Game_id")
    private List<Round> rounds;

    public Game(int scoreLimit) {
        this.scoreLimit = scoreLimit;
        this.win = 0;
        this.lose = 0;
        this.rounds = new ArrayList<>();
    }
}
