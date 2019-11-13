package com.ndirangu.scoutwatch.serviceImpl;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.repostiory.ClubRepository;
import com.ndirangu.scoutwatch.repostiory.PlayerRepository;
import com.ndirangu.scoutwatch.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
   private PlayerRepository playerRepository;
//   private ClubRepository clubRepository;


    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
//        this.clubRepository = clubRepository;
    }

    @Override
    public Page<Player> listAll(Pageable pageable) throws Exception{
        return playerRepository.findAll(pageable);
    }

    @Override
    public Optional<Player> findOne(Long id) throws Exception {
        playerRepository.findById(id).orElseThrow(() -> new Exception("player with id "+id+ " not found"));
        return playerRepository.findById(id);
    }

    @Override
    public Long create(Player player) {
        return playerRepository.save(player).getId();
    }

    @Override
    public Long assignClub(Player player) throws Exception {
        playerRepository.findById(player.getId()).orElseThrow(()-> new Exception("Player with id "+player.getId()+" not found"));
//        clubRepository.findById(club.getId()).orElseThrow(() -> new Exception("club with id"+club.getId()+" not found"));
        return playerRepository.save(player).getId();
    }
}
