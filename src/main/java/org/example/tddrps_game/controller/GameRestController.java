package org.example.tddrps_game.controller;

import org.example.tddrps_game.entity.Game;
import org.example.tddrps_game.entity.Round;
import org.example.tddrps_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // http://localhost:8080/api/tester
@CrossOrigin(origins = "http://localhost:3000")
@Transactional
public class GameRestController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGame(){
        return ResponseEntity.ok(gameService.findAllGames());
    }

    @PostMapping("/game")
    public ResponseEntity<Game> createGame(@Validated int scoreLimit){
        Game game = gameService.createGame(scoreLimit);
        return ResponseEntity.ok(game);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Game> getGameById(@Validated long id){
        return ResponseEntity.ok(gameService.findGameById(id));
    }

    @GetMapping("/game/{id}/rounds")
    public ResponseEntity<List<Round>> getAllRounds(@Validated long id){
        return ResponseEntity.ok(gameService.getAllRound(id));
    }

    @PostMapping("/game/{id}/round")
    public ResponseEntity<Round> createRoundToGame(@Validated long id, @Validated String playerMove){
        Round round = gameService.createRound(playerMove);
        if (gameService.addRoundToGame(id,round)){
            return ResponseEntity.ok(round);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
