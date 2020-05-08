package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.helpingClasses.HelpingClass2;
import com.example.portalspolecznosciowy.models.Comments;
import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.CommentsRepository;
import com.example.portalspolecznosciowy.services.CommentsServices;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class photoController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private PhotosServices photosServices;
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private CommentsServices commentsServices;

    private String userr;

    @GetMapping("/photo/{id}")
    public ModelAndView photo(@PathVariable("id") long id)
    {
        ModelAndView modelAndView = new ModelAndView("photo");
        Photos photos = photosServices.findPhotoDetails(id);
        User userinfo = userServices.getUserDetailsByPhotoId(photos.getPhoto_id());
        List<Comments> comments = commentsServices.getPhotoDetailById(id);
        List<HelpingClass2> helpingClass2 = new ArrayList<>();
        for (Comments c : comments) {
            helpingClass2.add(new HelpingClass2(commentsServices.getUserNicknameById(c.getComment_id()),c.getDescription(),c.getDate()));
        }
        modelAndView.addObject("current_user",userServices.findUserId(userr));
        modelAndView.addObject("userinfo",userinfo);
        modelAndView.addObject("userdetails",helpingClass2);
        modelAndView.addObject("photodetails",photos);
        return modelAndView;
    }
    @PostMapping("/photo/{id}")
    public ModelAndView addcomment(@PathVariable("id") String id, @ModelAttribute("comments") Comments comments) {
        ModelAndView modelAndView  = new ModelAndView("redirect:/");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userr = authentication.getName();
        comments.setUser(userServices.findUserId(userr));
        Date today = new Date();
        comments.setDate(today);
        comments.setDescription(comments.getDescription());
        comments.setPhotos(photosServices.findPhotoDetails(Integer.parseInt(id)));
        commentsRepository.save(comments);
        return modelAndView;
    }
}
