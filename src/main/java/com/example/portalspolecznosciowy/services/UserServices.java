package com.example.portalspolecznosciowy.services;

import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public boolean checkifuserexists(String email, String nickname) {
        User user = userRepository.findByEmailorNickname(email,nickname);
        if (user == null) return true;
        else return false;
    }

    public User findUserId(String email) {
        User user = userRepository.findIdByEmail(email);
        return user;
    }
    public long findUserIdLong(String email) {
        User user = userRepository.findIdByEmailLong(email);
        return user.getId();
    }

    public List<User> proponowaniUzytkownicy() {
        List<User> users = new ArrayList<User>();
        userRepository.getAllUsers().forEach(users::add);
        return users;
    }
}