package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Api(tags = {"Player"})
@RequestMapping("/player")
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

    @ApiOperation(value = "finds one player")
    @GetMapping("/{playerId}")
    public @ResponseBody
    Optional<Player> findOne(@PathVariable Long playerId) throws Exception {
        playerService.findOne(playerId).orElseThrow(() -> new Exception("player with id "+playerId+" not found"));
        return playerService.findOne(playerId);
    }

    @ApiOperation(value = "assign player to a club")
    @PostMapping("/transfer/{playerId}")
    public @ResponseBody Long transfer(@PathVariable Long playerId, @RequestBody Player player, @RequestBody Club club)throws Exception{
        playerService.findOne(playerId).orElseThrow(() -> new Exception("player with id "+playerId+" not found"));
        player.setFirstName(player.getFirstName());
        player.setLastName(player.getLastName());
        player.setPosition(player.getPosition());
        player.setNationality(player.getNationality());
        player.setValue(player.getValue());
        return playerService.assignClub(player);

    }

}
