package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.helpingClasses.HelpingClass3;
import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.services.PhotosServices;
import com.example.portalspolecznosciowy.services.SectionsServices;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class sectionsController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private SectionsServices sectionsServices;
    @Autowired
    private PhotosServices photosServices;

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
    @GetMapping("/sections/{section_id}")
        public ModelAndView generatephotosinsections(@PathVariable("section_id") String section_id) {
            ModelAndView modelAndView = new ModelAndView("photosections");

            List<Photos> photo = photosServices.getPhotosBySection(Long.parseLong(section_id));
            List<HelpingClass3> photohc = new ArrayList<>();
            for (Photos p : photo) {
                photohc.add(new HelpingClass3(p.getPhoto_id(),p.getDate(),p.getDescription(),p.getTags(),p.getName_photo(),p.getSource(),userServices.findUserNicknameByPhotoId(p.getUser().getId())));
            }
            modelAndView.addObject("section_name",sectionsServices.findSectionName(Long.parseLong(section_id)));
            modelAndView.addObject("photo",photohc);
            return modelAndView;
    }

}
