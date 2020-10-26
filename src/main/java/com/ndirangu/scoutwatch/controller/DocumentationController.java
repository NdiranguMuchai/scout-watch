package com.ndirangu.scoutwatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DocumentationController {

    @RequestMapping({"/docs.html","/docs"})
    public String getDocs(){
        return "docs";
    }
}
