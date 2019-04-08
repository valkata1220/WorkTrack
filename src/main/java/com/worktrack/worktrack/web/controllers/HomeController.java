package com.worktrack.worktrack.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{

    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/company-index")
    @PreAuthorize("isAnonymous()")
    public ModelAndView company(ModelAndView modelAndView){
        modelAndView.setViewName("company-index");
        return modelAndView;
    }

    @GetMapping("/worker-index")
    @PreAuthorize("isAnonymous()")
    public ModelAndView worker(ModelAndView modelAndView){
        modelAndView.setViewName("worker-index");
        return modelAndView;
    }
}
