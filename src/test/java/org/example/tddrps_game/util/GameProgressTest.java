package org.example.tddrps_game.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameProgressTest {

    private final GameProgress gp = new GameProgress();

    @Test
    void getRandomAiMove_test() {
        for (int i = 0; i < 30; i++) {
            String move = gp.getRandomAiMove();
            assertTrue(move.equals("ROCK") || move.equals("PAPER") || move.equals("SCISSORS"));
        }
    }

    @Test
    void getResult_test() {
        assertEquals("DRAW", gp.getResult("ROCK", "ROCK"));
        assertEquals("WIN", gp.getResult("ROCK", "SCISSORS"));
        assertEquals("LOSE", gp.getResult("ROCK", "PAPER"));
        assertEquals("DRAW", gp.getResult("SCISSORS", "SCISSORS"));
        assertEquals("WIN", gp.getResult("PAPER", "ROCK"));
        assertEquals("LOSE", gp.getResult("SCISSORS", "ROCK"));
    }

    @Test
    void getMoveNumber_test() {
        assertEquals(0, gp.getMoveNumber("ROCK"));
        assertEquals(1, gp.getMoveNumber("PAPER"));
        assertEquals(2, gp.getMoveNumber("SCISSORS"));
    }


    @ParameterizedTest
    @MethodSource("argForRan")
    void getRandomNumber_test(int testTimes, int max, int min) {
        for (int i = 0; i < testTimes; i++) {
            int actual = gp.getRandomNumber(max, min);
            assertTrue(min <= actual);
            assertTrue(max >= actual);
        }
    }

    private static Stream<Arguments> argForRan() {
        //int testTimes, int max, int min
        return Stream.of(
                Arguments.of(10, 6, 3),
                Arguments.of(15, 2, 1),
                Arguments.of(20, 9, 2)
        );
    }
}