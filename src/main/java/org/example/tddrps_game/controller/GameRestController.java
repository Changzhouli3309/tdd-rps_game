package org.example.tddrps_game.controller;

import org.example.tddrps_game.entity.Game;
import org.example.tddrps_game.entity.Round;
import org.example.tddrps_game.model.GameReq;
import org.example.tddrps_game.model.RoundReq;
import org.example.tddrps_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // http://localhost:8080/api
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
    public ResponseEntity<Game> createGame(@Validated @RequestBody GameReq gameReq){
        Game game = gameService.createGame(gameReq.getScoreLimit());
        return ResponseEntity.ok(game);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable int id){
        return ResponseEntity.ok(gameService.findGameById(id));
    }

    @GetMapping("/game/{id}/rounds")
    public ResponseEntity<List<Round>> getAllRounds(@PathVariable int id){
        return ResponseEntity.ok(gameService.getAllRound(id));
    }

    @PostMapping("/game/{id}/round")
    public ResponseEntity<Round> createRoundToGame(@PathVariable int id, @RequestBody RoundReq roundReq){
        Round round = gameService.createRound(roundReq.getPlayerMove());
        if (gameService.addRoundToGame(id,round)){
            return ResponseEntity.ok(round);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/game/{id}")
    public ResponseEntity<Game> deleteGame(@PathVariable int id){
        if (gameService.deleteGame(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
