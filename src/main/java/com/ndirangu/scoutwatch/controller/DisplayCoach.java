package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.repostiory.CoachRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayCoach {
   private CoachRepository coachRepository;

    public DisplayCoach(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }
    @RequestMapping("/coaches")
    public String getCoaches(Model model){
        model.addAttribute("coaches", coachRepository.findAll());
        return "coach/coaches";
    }
}
