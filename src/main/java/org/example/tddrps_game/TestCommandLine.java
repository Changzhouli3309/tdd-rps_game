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
        Game g1 = gameService.createGame(1);
        long id1 = g1.getId();

        Game g2 = gameService.createGame(2);
        long id2 = g2.getId();

        //"ROCK", "PAPER", "SCISSORS"
        Round r1 = gameService.createRound("ROCK");
        Round r2 = gameService.createRound("PAPER");
        Round r3 = gameService.createRound("SCISSORS");

        gameService.addRoundToGame(id1, r1);
        gameService.addRoundToGame(id1, r2);
        gameService.addRoundToGame(id2, r3);

        g1.getRounds().add(r1);
        g1.getRounds().add(r2);
        g2.getRounds().add(r3);
    }
}
