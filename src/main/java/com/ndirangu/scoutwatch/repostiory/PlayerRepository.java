package com.ndirangu.scoutwatch.repostiory;

import com.ndirangu.scoutwatch.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
Optional<Player> findById(Long playerId);
}
