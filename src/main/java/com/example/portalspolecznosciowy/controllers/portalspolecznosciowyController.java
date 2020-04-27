package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.repositories.FollowersRepository;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class portalspolecznosciowyController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private FollowersRepository followersRepository;

    public static String userr;

    @GetMapping("/")
    public ModelAndView indexrender() {
        ModelAndView modelAndView = new ModelAndView("index");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userr = authentication.getName();
        if (userr == null) {
            modelAndView.addObject("users",userServices.wszyscyUzytkownicy());
        }
        else modelAndView.addObject("users",userServices.proponowaniUzytkownicy(userr));

        return modelAndView;
    }
}

