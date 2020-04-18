package com.example.portalspolecznosciowy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    /*
    @PostMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }
    */
}
