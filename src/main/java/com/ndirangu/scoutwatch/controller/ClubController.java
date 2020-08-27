package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.service.ClubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;
@Api(tags = {"Club"})
@RestController
@RequestMapping("/club")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @ApiOperation(value = "Returns a list of all clubs")
    @GetMapping({"","/"})
    public  @ResponseBody
    Page<Club> list(Pageable pageable){
        return clubService.list(pageable);
    }

    @ApiOperation(value = "Finds a club based on its id")
    @GetMapping("/{clubId}")
    public @ResponseBody
    Optional<Club> findOne(@PathVariable UUID clubId) throws Exception{
        clubService.findOne(clubId).orElseThrow(()-> new Exception("coach with id "+clubId+" not found"));
        return clubService.findOne(clubId);
    }
    @ApiOperation(value = "Creates a club")
    @PostMapping("/create")
    public @ResponseBody UUID create(@RequestBody Club club) throws Exception{
        return clubService.create(club);
    }
    @ApiOperation(value = "Updates a club")
    @PutMapping("/{clubId}")
    public @ResponseBody UUID update(@RequestBody Club club, @PathVariable UUID clubId) throws Exception{
        clubService.findOne(clubId).orElseThrow(()-> new Exception("coach with id "+clubId+" not found"));
        club.setId(clubId);
        club.setCoach(club.getCoach());
        return clubService.update(club);
    }
}
