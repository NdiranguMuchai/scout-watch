package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerService {
    Page<Player> list(Pageable pageable);

}
