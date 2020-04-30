package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.services.SectionsServices;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class sectionsController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private SectionsServices sectionsServices;

    @GetMapping("/sections_find")
    public ModelAndView generatesections(@RequestParam("value") String value) {
        ModelAndView modelAndView = new ModelAndView("sections");
            System.out.println(value);
            modelAndView.addObject("sections",sectionsServices.allSections());
            modelAndView.addObject("users",userServices.findUsersByQuery(value));
            return  modelAndView;
    }
    @GetMapping("/sections")
    public ModelAndView generatesections() {
        ModelAndView modelAndView = new ModelAndView("sections");
        modelAndView.addObject("sections",sectionsServices.allSections());
        modelAndView.addObject("users",userServices.wszyscyUzytkownicy());
        return  modelAndView;
    }

}
