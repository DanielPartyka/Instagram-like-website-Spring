package com.example.portalspolecznosciowy.services;

import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.FollowersRepository;
import com.example.portalspolecznosciowy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowersServices {

    @Autowired
    UserRepository userRepository;

    public long howManyUsersFollowsThisUser(long id) {
        return userRepository.HowManyUsersFollwsCurrentUser(id);

    }
    public long howManyUserisFollwing(long id) {
         return userRepository.HowManyUserisFollwing(id);

    }
}
