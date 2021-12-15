package org.example.tddrps_game.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Round {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    private String playerMove, aiMove, result;

    public Round(String playerMove, String aiMove, String result) {
        this.playerMove = playerMove;
        this.aiMove = aiMove;
        this.result = result;
    }

}