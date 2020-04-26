package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.controllers.helpingClasses.HelpingClass;
import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.services.FollowersServices;
import com.example.portalspolecznosciowy.services.PhotosServices;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class userController {

    @Autowired
    private PhotosServices photosServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private FollowersServices followersServices;

    private static String userr;

    @GetMapping("/{nickname}")
    public ModelAndView userrender(@PathVariable("nickname") String nickname) {
        ModelAndView modelAndView = new ModelAndView("/user");
        userr = nickname;
        if (userr == null) {
            modelAndView.setViewName("/404");
            return modelAndView;
        } else {
            try {
                long user_id = userServices.findUserByNickname(userr);
                System.out.println(user_id);
                //Put data on web
                User user = userServices.findUserObjbyNickname(userr);
                modelAndView.addObject("user_nickname", user.getNickname());
                modelAndView.addObject("user_name", user.getName());
                modelAndView.addObject("user_surname", user.getSurname());
                //HowManyPhotos Does the user posted
                long howmanyPhotos = photosServices.howManyPhotos(user_id);
                HelpingClass helpingClass = new HelpingClass(howmanyPhotos);
                modelAndView.addObject("hmp", helpingClass);
                //HowManyUsersFollowsthisUser
                howmanyPhotos = followersServices.howManyUsersFollowsThisUser(user_id);
                HelpingClass helpingClass1 = new HelpingClass(howmanyPhotos);
                modelAndView.addObject("hmuftu", helpingClass1);
                //HowManyUserFollows
                howmanyPhotos = followersServices.howManyUserisFollwing(user_id);
                HelpingClass helpingClass2 = new HelpingClass(howmanyPhotos);
                modelAndView.addObject("hmuf", helpingClass2);
                return modelAndView;
            } catch (NullPointerException e) {
                System.out.println("Nie znaleziono uzytkownika");
                modelAndView.setViewName("/404");
                return modelAndView;
            }
        }
    }
}
