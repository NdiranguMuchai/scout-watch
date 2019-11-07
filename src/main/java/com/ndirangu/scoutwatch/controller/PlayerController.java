package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("players")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public @ResponseBody
    Page<Player> showAll(Pageable pageable)throws Exception{
        return playerService.listAll(pageable);
    }


}
