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

    @GetMapping("/sections")
    public ModelAndView generatesections(@RequestParam("q") String q) {
        ModelAndView modelAndView = new ModelAndView("sections");
            System.out.println(q);
            modelAndView.addObject("sections",sectionsServices.allSections());
            modelAndView.addObject("users",userServices.wszyscyUzytkownicy());
            return  modelAndView;
    }
    @GetMapping("/userfinder")
    public ModelAndView finduser(@PathVariable("q") String q){
        ModelAndView modelAndView = new ModelAndView("userfinder");
        modelAndView.addObject("users",userServices.findUsersByQuery(q));
        return modelAndView;
    }

}
