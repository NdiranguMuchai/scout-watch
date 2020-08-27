package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface PlayerService {
    Page<Player> list(Pageable pageable);
    Optional<Player> findOne(UUID id) throws Exception;
    UUID create(Player player);
    UUID assignClub(UUID clubId) throws  Exception;

}
