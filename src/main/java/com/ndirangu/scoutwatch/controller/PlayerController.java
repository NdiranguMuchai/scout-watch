package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.service.ClubService;
import com.ndirangu.scoutwatch.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;
    private final ClubService clubService;

    public PlayerController(PlayerService playerService, ClubService clubService) {
        this.playerService = playerService;
        this.clubService = clubService;
    }

    @GetMapping({"","/"})
    public  @ResponseBody Page<Player> list(Pageable pageable){
        return playerService.list(pageable);
    }

    @PostMapping("/create")
    public @ResponseBody
    UUID create(@RequestBody Player player){
        return playerService.create(player);
    }

    @PutMapping("/{playerId}/sign/{clubId}")
    public @ResponseBody UUID assignClub(@PathVariable UUID playerId,
                                         @RequestBody Player player,
                                         @PathVariable UUID clubId
                                          ) throws  Exception{
        playerService.findOne(playerId).orElseThrow(()-> new Exception("player with id "+playerId+" not found"));
        return playerService.assignClub(clubId);

    }
}
