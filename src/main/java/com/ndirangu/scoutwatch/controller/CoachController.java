package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.service.CoachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(value = "Coach",tags = {"Coach"})
@RequestMapping("/coach")
public class CoachController {
    private CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @ApiOperation(value = "view coaches ", notes = "views a list of all coaches")
    @GetMapping
    public Page<Coach> listAll(Pageable pageable){
        return coachService.listAll(pageable);
    }

    @ApiOperation(value = "find one coach", notes = "returns a single coach based on id")
    @GetMapping("/{coachId}")
    public Optional<Coach> findOne( @PathVariable Long coachId) throws Exception{
        return coachService.findById(coachId);
    }
    @ApiOperation(value = "create a coach" )
    @PostMapping("/create")
    public @ResponseBody Long create(@RequestBody Coach coach){
        return coachService.create(coach);
    }
    @ApiOperation(value = "update a coach")
    @PutMapping("/{coachId}")
    public @ResponseBody Long update(@RequestBody Coach coach, @PathVariable Long coachId)throws Exception{
        coachService.findById(coachId).orElseThrow(()-> new Exception("coach with id "+coachId+" not found"));
        coach.setId(coachId);
        return coachService.update(coach);
    }
}
