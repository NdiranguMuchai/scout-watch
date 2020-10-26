package com.ndirangu.scoutwatch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"","/","/index","/index.html"})
@RestController
public class IndexController {
    public String index(){
        return "index";
    }
}
