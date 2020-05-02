package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.helpingClasses.HelpingClass3;
import com.example.portalspolecznosciowy.helpingClasses.HelpingClass4;
import com.example.portalspolecznosciowy.models.Followers;
import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.FollowersRepository;
import com.example.portalspolecznosciowy.repositories.UserRepository;
import com.example.portalspolecznosciowy.services.FollowersServices;
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

import java.util.ArrayList;
import java.util.List;

@Controller public class followController {

    @Autowired
    UserServices userServices;
    @Autowired
    FollowersRepository followersRepository;
    @Autowired
    FollowersServices followersServices;

    private String userr;


    @PostMapping("/follow_user")
    public ModelAndView indexfollow(@ModelAttribute("followers") Followers followers, @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Jest problem z " + result);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userr = authentication.getName();
        followers.setUser(userServices.findUserId(userr));
        User u = userServices.findUserId(user.getEmail());
        followers.setFollower_id(u);
        followersRepository.save(followers);
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/list_of_followers")
    public ModelAndView list_of_followers() {
        ModelAndView modelAndView = new ModelAndView("list_of_followers");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userr = authentication.getName();
        User usercheck = userServices.findUserId(userr);
        List<Followers> flist = followersServices.followers_id(usercheck.getId());
        List<HelpingClass4> users = new ArrayList<>();
        for (Followers f : flist) {
            User u = userServices.getAllUsersById(f.getFollower_id().getId());
            users.add(new HelpingClass4(u.getNickname(),u.getName(),u.getSurname(),u.getDescription()));
        }
        modelAndView.addObject("users",users);
        return  modelAndView;
    }
}
