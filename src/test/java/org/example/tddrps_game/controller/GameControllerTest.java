package org.example.tddrps_game.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GameControllerTest {

    @Autowired
    GameController gameController;

    @Test
    void test() {

        String actual = gameController.createGame(3);

        assertEquals("", actual);
    }
}