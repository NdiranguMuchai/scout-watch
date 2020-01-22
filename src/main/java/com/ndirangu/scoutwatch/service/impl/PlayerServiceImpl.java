package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.repostiory.PlayerRepository;
import com.ndirangu.scoutwatch.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlayerServiceImpl implements PlayerService {
   private PlayerRepository playerRepository;


    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Set<Player> findAll() {
        return null;
    }

    @Override
    public Player findById(Long aLong) {
        return null;
    }

    @Override
    public Player save(Player object) {
        return null;
    }

    @Override
    public void delete(Player object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
