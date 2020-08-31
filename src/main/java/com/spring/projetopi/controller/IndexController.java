package com.spring.projetopi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String GoToIndex(){
        return "index";
    }
}
