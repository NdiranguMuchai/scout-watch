package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.repository.ClubRepository;
import com.ndirangu.scoutwatch.repository.PlayerRepository;
import com.ndirangu.scoutwatch.repository.PositionRepository;
import com.ndirangu.scoutwatch.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PositionRepository positionRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, PositionRepository positionRepository) {
        this.playerRepository = playerRepository;
        this.positionRepository = positionRepository;
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

    @Override
    public UUID assignPosition(UUID playerId, UUID positionId) throws Exception {
        playerRepository.findById(playerId).orElseThrow(()-> new Exception("player with id "+playerId+" not found"));
        positionRepository.findById(positionId).orElseThrow(()-> new Exception("position with id "+positionId+" not found"));

        Player player = new Player();
        player.setId(playerId);
        player.setName(player.getName());
        player.setClub(player.getClub());

        return playerRepository.save(player).getId();
    }
}
