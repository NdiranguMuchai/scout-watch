package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.repository.ClubRepository;
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
    private final ClubRepository clubRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, ClubRepository clubRepository) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
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
    public UUID assignClub(UUID clubId) throws Exception {
        Player player = new Player();
        return  clubRepository.findById(clubId).map(club -> {
            player.setClub(club);
            return clubId;
        }).orElseThrow(()-> new Exception("club with id "+clubId+" doesn't exist"));

    }

}
