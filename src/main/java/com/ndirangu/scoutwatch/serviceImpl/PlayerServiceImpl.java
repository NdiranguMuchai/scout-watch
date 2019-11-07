package com.ndirangu.scoutwatch.serviceImpl;

import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.repostiory.PlayerRepository;
import com.ndirangu.scoutwatch.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
   private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Page<Player> listAll(Pageable pageable) throws Exception{
        return playerRepository.findAll(pageable);
    }

    @Override
    public Long create(Player player) {
        return playerRepository.save(player).getId();
    }
}
