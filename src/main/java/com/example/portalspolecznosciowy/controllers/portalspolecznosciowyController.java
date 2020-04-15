package com.example.portalspolecznosciowy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class portalspolecznosciowyController {

    @GetMapping("/")
    public String indexrender()
    {
        return "index";
    }
    @GetMapping("/registration")
    public String registrationrender()
    {
        return "registration";
    }

    @GetMapping("/login")
    public String loginrender()
    {
        return "login";
    }

    @GetMapping("/user")
    public String userrender()
    {
        return "user";
    }
}

