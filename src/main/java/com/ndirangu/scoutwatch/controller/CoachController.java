package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.service.CoachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/coach")
public class CoachController {
    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping({"","/"})
    public  @ResponseBody Page<Coach> list(Pageable pageable){
        return coachService.list(pageable);
    }

    @GetMapping("/{coachId}")
    public @ResponseBody
    Optional<Coach> findOne(@PathVariable UUID coachId) throws Exception{
        coachService.findOne(coachId).orElseThrow(()-> new Exception("coach with id "+coachId+" not found"));
        return coachService.findOne(coachId);
    }

    @PostMapping("/create")
    public @ResponseBody UUID create(@RequestBody Coach coach) throws Exception{
        return coachService.create(coach);
    }

    @PutMapping("/{coachId}")
    public @ResponseBody UUID update(@RequestBody Coach coach, @PathVariable UUID coachId) throws Exception{
        coachService.findOne(coachId).orElseThrow(()-> new Exception("coach with id "+coachId+" not found"));
        coach.setId(coachId);
        return coachService.update(coach);
    }
}
