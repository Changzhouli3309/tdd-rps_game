package org.example.tddrps_game.service;

import org.example.tddrps_game.entity.Game;
import org.example.tddrps_game.entity.Round;
import org.example.tddrps_game.repository.GameRepo;
import org.example.tddrps_game.repository.RoundRepo;
import org.example.tddrps_game.util.GameProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImp implements GameService {

    private final GameRepo gameRepo;
    private final RoundRepo roundRepo;
    private final GameProgress gameProgress;

    @Autowired
    public GameServiceImp(GameRepo gameRepo, RoundRepo roundRepo) {
        this.gameRepo = gameRepo;
        this.roundRepo = roundRepo;
        this.gameProgress = new GameProgress();
    }

    @Override
    public Game createGame(int scoreLimit) {
        return gameRepo.save(new Game(scoreLimit));
    }

    @Override
    public List<Game> findAllGames() {
        return (List<Game>) gameRepo.findAll();
    }

    @Override
    public Game findGameById(int id) {
        return gameRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Round> getAllRound(int id) {
        return findGameById(id).getRounds();
    }

    @Override
    public Round createRound(String playerMove) {
        String aiMove = gameProgress.getRandomAiMove();
        String result = gameProgress.getResult(playerMove, aiMove);
        return roundRepo.save(new Round(playerMove, aiMove, result));
    }

    @Override
    public boolean addRoundToGame(int id, Round round) {
        Game game = findGameById(id);
        if (game != null) {
            List<Round> rounds = game.getRounds();
            rounds.add(round);
            game.setRounds(rounds);

            game = gameProgress.updateScore(game);

            gameRepo.save(game);
            return true;
        }
        return false;
    }

}
