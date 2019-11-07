package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.repostiory.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayPlayers {
    private PlayerRepository playerRepository;

    public DisplayPlayers(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    @RequestMapping("/players")
    public String getPlayers(Model model){
        model.addAttribute("players", playerRepository.findAll());
        return "players";
    }
}
