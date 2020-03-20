package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.repository.PlayerRepository;
import com.ndirangu.scoutwatch.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Page<Player> list(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @Override
    public Optional<Player> findOne(UUID id) throws Exception{
       playerRepository.findById(id).orElseThrow(()-> new Exception("player with id "+id+" not found"));
        return playerRepository.findById(id);
    }

    @Override
    public UUID create(Player player) {
        return playerRepository.save(player).getId();
    }
}
