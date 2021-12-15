package org.example.tddrps_game.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameReq {
    private int scoreLimit;
    private String testString;
}
