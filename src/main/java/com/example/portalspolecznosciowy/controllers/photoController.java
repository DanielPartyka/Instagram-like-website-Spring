package com.example.portalspolecznosciowy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class photoController {

    @GetMapping("/{photo_id}")
    public ModelAndView photo(@PathVariable("photo_id") Long photo_id)
    {
        ModelAndView modelAndView = new ModelAndView("photo");

        return modelAndView;
    }
}
