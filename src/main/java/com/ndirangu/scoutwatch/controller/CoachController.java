package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.service.CoachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coach")
public class CoachController {
    private CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public Page<Coach> listAll(Pageable pageable){
        return coachService.listAll(pageable);
    }
}
