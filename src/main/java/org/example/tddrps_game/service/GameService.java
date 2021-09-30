package org.example.tddrps_game.service;

import org.example.tddrps_game.entity.Game;
import org.example.tddrps_game.entity.Round;

import java.util.List;

public interface GameService {
    Game createGame(int scoreLimit);

    List<Game> findAllGames();

    Game findGameById(int id);

    List<Round> getAllRound(int id);

    Round createRound(String playerMove);

    boolean addRoundToGame(int id, Round round);

}
