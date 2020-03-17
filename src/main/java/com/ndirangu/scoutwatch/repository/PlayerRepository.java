package com.ndirangu.scoutwatch.repository;

import com.ndirangu.scoutwatch.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
