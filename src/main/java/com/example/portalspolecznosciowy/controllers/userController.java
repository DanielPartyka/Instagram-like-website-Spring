package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.controllers.helpingClasses.HelpingClass;
import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.services.PhotosServices;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class userController {

    @Autowired
    private PhotosServices photosServices;
    @Autowired
    private UserServices userServices;

    private static String uzytkownik;

    @GetMapping("/user")
    public ModelAndView userrender() {
        ModelAndView modelAndView = new ModelAndView("user");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        uzytkownik = authentication.getName();
        long user_id = userServices.findUserIdLong(uzytkownik);
        long howmanyPhotos = photosServices.howManyPhotos(user_id);
        HelpingClass helpingClass = new HelpingClass(howmanyPhotos);
        modelAndView.addObject("hmp",helpingClass);
        return modelAndView;
    }
}
