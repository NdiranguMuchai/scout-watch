package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.service.ClubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Api(tags = {"Club"})
@RequestMapping("/club")
public class ClubController {
    private ClubService clubService;

    public ClubController( ClubService clubService) {
        this.clubService = clubService;
    }

    @ApiOperation(value = "return all clubs")
    @GetMapping
    public Page<Club> showAll(Pageable pageable){
        return clubService.listAll(pageable);
    }

    @ApiOperation(value = "return one club")
    @GetMapping("/{clubId}")
    public @ResponseBody
    Optional<Club> findOne(@PathVariable Long clubId){
        return clubService.findOne(clubId);
    }

    @ApiOperation(value = "create a club")
    @PostMapping("/create")
    public @ResponseBody Long create (@RequestBody Club club) {
        return clubService.create(club);
    }

    @ApiOperation(value = "update a club")
    @PutMapping("/{clubId}")
    public @ResponseBody Long update(@RequestBody Club club, @PathVariable Long clubId)throws Exception{
        clubService.findOne(clubId).orElseThrow(()-> new Exception("club with id "+clubId+" not found"));
        club.setId(clubId);
        return clubService.update(club);
    }



}
