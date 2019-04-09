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
        return super.view("index");
    }

    @GetMapping("/company-index")
    @PreAuthorize("isAnonymous()")
    public ModelAndView company(ModelAndView modelAndView){
        return super.view("company-index");
    }

    @GetMapping("/worker-index")
    @PreAuthorize("isAnonymous()")
    public ModelAndView worker(ModelAndView modelAndView){
       return super.view("worker-index");
    }
}
