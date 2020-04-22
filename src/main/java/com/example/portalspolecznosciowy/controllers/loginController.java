package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/login")
    public ModelAndView loginintoservice() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
}
