package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.models.Followers;
import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.FollowersRepository;
import com.example.portalspolecznosciowy.repositories.UserRepository;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller public class followController {

    @Autowired
    UserServices userServices;
    @Autowired
    FollowersRepository followersRepository;

    private String userr;


    @PostMapping("/follow_user")
    public ModelAndView indexfollow(@ModelAttribute("followers") Followers followers, @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Jest problem z " + result);
        }
        ModelAndView modelAndView = new ModelAndView("index");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userr = authentication.getName();
        followers.setUser(userServices.findUserId(userr));
        User u = userServices.findUserId(user.getEmail());
        followers.setFollower_id(u);
        followersRepository.save(followers);
        return modelAndView;
    }
}
