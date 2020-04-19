package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.UserRepository;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class registrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServices userServices;

    @GetMapping("/registration")
    public ModelAndView registeruser ()
    {
        ModelAndView modelAndView = new ModelAndView("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registeruser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("login");

            if (userServices.checkifuserexists(user.getEmail(),user.getNickname())) {

                user.setName(user.getName());
                user.setSurname(user.getSurname());
                user.setEmail(user.getEmail());
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                user.setPassword(encoder.encode(user.getPassword()));
                user.setSex(user.getSex());
                user.setDescription(user.getDescription());
                userRepository.save(user);
            }
            else {
                modelAndView.addObject("checkifuserexists",true);
                modelAndView.setViewName("registration");
            }
        return modelAndView;
    }
}
