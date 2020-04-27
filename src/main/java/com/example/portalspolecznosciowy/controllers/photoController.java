package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.models.Comments;
import com.example.portalspolecznosciowy.repositories.CommetsRepository;
import com.example.portalspolecznosciowy.services.PhotosServices;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class photoController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private PhotosServices photosServices;
    @Autowired
    private CommetsRepository commetsRepository;

    private String userr;

    @GetMapping("/photo/id")
    public ModelAndView photo()
    {
        ModelAndView modelAndView = new ModelAndView("photo");
        return modelAndView;
    }
    @PostMapping("/photo/id")
    public ModelAndView addcomment(@PathVariable("photo_id") long photo_id, @ModelAttribute("comments") Comments comments) {
        ModelAndView modelAndView  = new ModelAndView("photo");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userr = authentication.getName();
        comments.setUser(userServices.findUserId(userr));
        Date today = new Date();
        comments.setDate(today);
        comments.setDescription(comments.getDescription());
        comments.setPhotos(photosServices.findPhotoDetails(photo_id));
        commetsRepository.save(comments);
        return modelAndView;
    }
}
