package com.ndirangu.scoutwatch.repostiory;

import com.ndirangu.scoutwatch.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
