package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.service.ClubService;
import com.ndirangu.scoutwatch.service.CoachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;
@Api(tags = {"Coach"})
@RestController
@RequestMapping("/coach")
public class CoachController {
    private final CoachService coachService;
    private final ClubService clubService;

    public CoachController(CoachService coachService,
                           ClubService clubService) {
        this.coachService = coachService;
        this.clubService = clubService;
    }

    @ApiOperation(value = "Returns a list of all coaches")
    @GetMapping({"","/"})
    public  @ResponseBody Page<Coach> list(Pageable pageable){
        return coachService.list(pageable);
    }

    @ApiOperation(value = "Finds a coach based on id ")
    @GetMapping("/{coachId}")
    public @ResponseBody
    Optional<Coach> findOne(@PathVariable UUID coachId) throws Exception{
        coachService.findOne(coachId).orElseThrow(()-> new Exception("coach with id "+coachId+" not found"));
        return coachService.findOne(coachId);
    }

    @ApiOperation(value = "Creates a coach")
    @PostMapping("/create")
    public @ResponseBody UUID create(@RequestBody Coach coach) throws Exception{
        return coachService.create(coach);
    }

    @ApiOperation(value = "Updates a coach's details")
    @PutMapping("/{coachId}")
    public @ResponseBody UUID update(@RequestBody Coach coach, @PathVariable UUID coachId) throws Exception{
        coachService.findOne(coachId).orElseThrow(()-> new Exception("coach with id "+coachId+" not found"));
        coach.setId(coachId);
        return coachService.update(coach);
    }

    @ApiOperation(value = "Assigns a coach to a club")
    @PutMapping("/{coachId}/update-club/{clubId}")
    public @ResponseBody UUID assignClub(@PathVariable UUID coachId,
                                         @PathVariable UUID clubId,
                                          Coach coach) throws Exception{
        coachService.findOne(coachId).orElseThrow(()-> new Exception("coach with id "+coachId+" not found"));

        coach.setId(coachId);
        coach.setName(coach.getName());
        coach.setClub(clubService.findOne(clubId).orElseThrow(()-> new Exception("club with id "+clubId+" not found")));

        return coachService.assignClub(clubId, coach);
    }

}
