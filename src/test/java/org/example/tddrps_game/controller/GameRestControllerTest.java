package org.example.tddrps_game.controller;

import org.example.tddrps_game.entity.Game;
import org.example.tddrps_game.entity.Round;
import org.example.tddrps_game.service.GameService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameRestControllerTest {

    private final GameRestController gameRestController;
    private final GameService gameService;

    @Autowired
    public GameRestControllerTest(GameRestController gameRestController, GameService gameService) {
        this.gameRestController = gameRestController;
        this.gameService = gameService;
    }

    private Game g1, g2;
    private Round r1, r2, r3;
    private Long id1, id2;

    @BeforeEach
    void init() {
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

        g1.getRounds().add(r1);
        g1.getRounds().add(r2);
        g2.getRounds().add(r3);
    }

    @Test
    void getAllGame_test() {
        List<Game> expect = List.of(g1, g2);
        List<Game> actual = Objects.requireNonNull(gameRestController.getAllGame().getBody());
        assertEquals(expect.toString(), actual.toString());
    }

    @Test
    void getGameById_test() {
        String expect = g1.toString();
        String actual = Objects.requireNonNull(gameRestController.getGameById(id1).getBody()).toString();
        assertEquals(expect, actual);

        expect = g2.toString();
        actual = Objects.requireNonNull(gameRestController.getGameById(id2).getBody()).toString();
        assertEquals(expect, actual);
    }

    @Test
    void getAllRounds_test() {
        List<Round> expect = List.of(r1, r2);
        List<Round> actual = Objects.requireNonNull(gameRestController.getAllRounds(id1).getBody());
        assertEquals(expect.toString(), actual.toString());
    }

    @Test
    void createRoundToGame_test() {
        Round r4 = gameRestController.createRoundToGame(id2, "ROCK").getBody();
        assert r4 != null;
        List<Round> expect = List.of(r3, r4);
        List<Round> actual = Objects.requireNonNull(gameRestController.getAllRounds(id2).getBody());
        assertEquals(expect.toString(), actual.toString());
    }
}