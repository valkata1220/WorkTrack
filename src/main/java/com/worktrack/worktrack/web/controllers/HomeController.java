package com.worktrack.worktrack.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/company")
    public ModelAndView company(ModelAndView modelAndView){
        modelAndView.setViewName("company");
        return modelAndView;
    }
}
