package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/club")
public class ClubController {
    private ClubService clubService;

    public ClubController( ClubService clubService) {
        this.clubService = clubService;
    }


    @GetMapping
    public @ResponseBody
    Page<Club> showAll(Pageable pageable){
        return clubService.listAll(pageable);
    }

}
