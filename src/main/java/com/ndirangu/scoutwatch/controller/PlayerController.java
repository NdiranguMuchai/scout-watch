package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = {"Player"})
@RequestMapping("player")
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

    @ApiOperation(value = "creates a player")
    @PostMapping("/create")
    public @ResponseBody Long create(@RequestBody Player player){
        return playerService.create(player);
    }


}
