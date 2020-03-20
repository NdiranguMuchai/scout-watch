package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.repository.PlayerRepository;
import com.ndirangu.scoutwatch.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PLayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PLayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Page<Player> list(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }
}
