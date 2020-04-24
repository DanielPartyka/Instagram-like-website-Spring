package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.models.Followers;
import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.UserRepository;
import com.example.portalspolecznosciowy.services.SectionsServices;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class portalspolecznosciowyController {

    @Autowired
    private UserServices userServices;

    public static String user;

    @GetMapping("/")
    public ModelAndView indexrender()
    {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users",userServices.proponowaniUzytkownicy());
        return modelAndView;
    }
    @PostMapping("/")
    public ModelAndView indexfollow(@ModelAttribute("followers") Followers followers, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Jest problem z " + result);
        }
        ModelAndView modelAndView = new ModelAndView("index");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user = authentication.getName();
        //setFollower.userid//userServices.findUserIdLong(user);

        return modelAndView;
    }

}

