package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.models.Sections;
import com.example.portalspolecznosciowy.repositories.PhotosRepository;
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

import java.util.Date;

@Controller
public class photoaddingController {

    @Autowired
    private SectionsServices sectionsServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private PhotosRepository photosRepository;

    public static String user;

    @GetMapping("/add_photo")
    public ModelAndView add_photorender() {
        ModelAndView modelAndView = new ModelAndView("add_photo");
        modelAndView.addObject("sections",sectionsServices.allSections());
        return modelAndView;
    }
    @PostMapping("/add_photo")
    public ModelAndView add_photorender(@ModelAttribute("photos") Photos photos,@ModelAttribute("sections") Sections sections, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Jest problem z " + result);
        }
        ModelAndView modelAndView = new ModelAndView("/user");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user = authentication.getName();
        photos.setUser(userServices.findUserId(user));
        photos.setSections(sectionsServices.findSectionByName(sections.getName()));
        photos.setTags(photos.getTags());
        photos.setDescription(photos.getDescription());
        photos.setName_photo(photos.getName_photo());
        Date today = new Date();
        photos.setDate(today);
        photosRepository.save(photos);
        return modelAndView;
    }
}
