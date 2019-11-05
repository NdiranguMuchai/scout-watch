package com.ndirangu.scoutwatch.repostiory;

import com.ndirangu.scoutwatch.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
