package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PlayerService {
    Page<Player> listAll(Pageable pageable)throws Exception;
    Optional<Player> findOne(Long id) throws Exception;
    Long create(Player player);
    Long assignClub(Player player) throws Exception;
}
