package org.example.tddrps_game;

import org.example.tddrps_game.entity.Game;
import org.example.tddrps_game.entity.Round;
import org.example.tddrps_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor = Exception.class)
public class TestCommandLine implements CommandLineRunner {

    @Autowired
    private GameService gameService;

    @Override
    public void run(String... args) throws Exception {
        Game g1, g2;
        Round r1, r2, r3;
        int id1, id2;

        g1 = gameService.createGame(1);
        id1 = g1.getId();

        g2 = gameService.createGame(2);
        id2 = g2.getId();

        //"ROCK", "PAPER", "SCISSORS"
        r1 = gameService.createRound("ROCK");
        r2 = gameService.createRound("PAPER");
        r3 = gameService.createRound("SCISSORS");

        gameService.addRoundToGame(id1, r1);
        gameService.addRoundToGame(id1, r2);
        gameService.addRoundToGame(id2, r3);
    }
}
