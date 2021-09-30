package org.example.tddrps_game.repository;

import org.example.tddrps_game.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends CrudRepository<Game,Integer> {
}
