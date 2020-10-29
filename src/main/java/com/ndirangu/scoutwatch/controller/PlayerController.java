package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.service.ClubService;
import com.ndirangu.scoutwatch.service.PlayerService;
import com.ndirangu.scoutwatch.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(tags = {"Player"})
@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;
    private final PositionService positionService;

    public PlayerController(PlayerService playerService, PositionService positionService) {
        this.playerService = playerService;
        this.positionService = positionService;
    }

    @ApiOperation(value = "Returns a list of all players")
    @GetMapping({"","/"})
    public  @ResponseBody Page<Player> list(Pageable pageable){
        return playerService.list(pageable);
    }

    @ApiOperation(value = "Creates a player")
    @PostMapping("/create")
    public @ResponseBody
    UUID create(@RequestBody Player player){
        return playerService.create(player);
    }

    @ApiOperation(value = "Assigns a player their position")
    @PutMapping("/{playerId}/position/{positionId}")
    public @ResponseBody UUID assignPosition(@PathVariable UUID playerId,
                                             @PathVariable UUID positionId) throws Exception{
        playerService.findOne(playerId).orElseThrow(()-> new Exception("Player with id "+playerId+" not found"));
        positionService.findOne(positionId).orElseThrow(()-> new Exception("Player with id "+positionId+" not found"));

        Player player = new Player();
        player.setId(playerId);
        player.setName(player.getName());
        player.setClub(player.getClub());

        return playerService.assignPosition(playerId,positionId);
    }

}
