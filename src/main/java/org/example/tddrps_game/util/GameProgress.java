package org.example.tddrps_game.util;

import org.example.tddrps_game.entity.Game;
import org.example.tddrps_game.entity.Round;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

public class GameProgress {
    private final String[] moves;
    private final String[] results;
    private final Random ran;

    public GameProgress() {
        this.moves = new String[]{"ROCK", "PAPER", "SCISSORS"};
        this.results = new String[]{"DRAW", "WIN", "LOSE"};
        this.ran = new Random();
    }

    public String getRandomAiMove() {
        return moves[getRandomNumber(2, 0)];
    }

    public String getResult(String playerMove, String aiMove) {

        int res = getMoveNumber(playerMove) - getMoveNumber(aiMove);
        if (res < 0) {
            res += 3;
        }

        return results[res];
    }

    public int getMoveNumber(String move) {
        for (int i = 0; i < moves.length; i++) {
            if (move.equals(moves[i])) return i;
        }
        throw new IllegalArgumentException("Illegal move");
    }

    public int getRandomNumber(int max, int min) {
        return ran.nextInt(max - min + 1) + min;
    }

    public Game updateScore(Game game){
        List<Round> rounds = game.getRounds();
        int win = 0, lose=0;
        for (Round r : rounds){
            if (r.getResult().equals("WIN")){
                win++;
            }
            if (r.getResult().equals("LOSE")){
                lose++;
            }
        }
        game.setWin(win);
        game.setLose(lose);
        return game;
    }

}
