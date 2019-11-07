package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerService {
    Page<Player> listAll(Pageable pageable)throws Exception;
    Long create(Player player);
}
