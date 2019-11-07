package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.service.CoachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Api(value = "Coach",tags = {"Coach"})
@RequestMapping("/coach")
public class CoachController {
    private CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @ApiOperation(value = "view a list of all coaches ", notes = "views a list of all coaches")
    @GetMapping
    public Page<Coach> listAll(Pageable pageable){
        return coachService.listAll(pageable);
    }

    @ApiOperation(value = "find one coach", notes = "returns a single coach based on id")
    @GetMapping("/{coachId}")
    public Optional<Coach> findOne( @PathVariable Long coachId) throws Exception{
        return coachService.findById(coachId);
    }
}
