package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.repostiory.ClubRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayClubs {
    private ClubRepository clubRepository;

    public DisplayClubs(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    @RequestMapping("/clubs")
    public String getClubs(Model model){
        model.addAttribute("clubs", clubRepository.findAll());
        return "club/clubs";
    }
}
