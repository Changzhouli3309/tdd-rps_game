package org.example.tddrps_game.service;

import org.example.tddrps_game.entity.Game;
import org.example.tddrps_game.entity.Round;

import java.util.List;

public interface GameService {
    Game createGame(int scoreLimit);

    List<Game> findAllGames();

    Game findGameById(long id);

    List<Round> getAllRound(long id);

    Round createRound(String playerMove, String aiMove, String result);

    Round createRound(String playerMove, String aiMove);

    Round createRound(String playerMove);

    boolean addRoundToGame(Long id, Round round);
}
