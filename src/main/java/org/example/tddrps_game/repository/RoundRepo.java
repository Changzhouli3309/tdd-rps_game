package org.example.tddrps_game.repository;

import org.example.tddrps_game.entity.Round;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepo extends CrudRepository<Round,Long> {
}
