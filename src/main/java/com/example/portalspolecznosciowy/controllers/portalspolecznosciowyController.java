package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.repositories.UserRepository;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class portalspolecznosciowyController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView indexrender()
    {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users",userServices.proponowaniUzytkownicy());
        return modelAndView;
    }

    @GetMapping("/user")
    public String userrender()
    {
        return "user";
    }
}

