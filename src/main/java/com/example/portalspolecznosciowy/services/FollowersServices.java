package com.example.portalspolecznosciowy.services;

import com.example.portalspolecznosciowy.models.Followers;
import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.FollowersRepository;
import com.example.portalspolecznosciowy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowersServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FollowersRepository followersRepository;

    public long howManyUsersFollowsThisUser(long id) {
        return userRepository.HowManyUsersFollwsCurrentUser(id);

    }
    public long howManyUserisFollwing(long id) {
         return userRepository.HowManyUserisFollwing(id);
    }

    public boolean checkifuserisfollowed(long id) {
        List<Followers> followersList = followersRepository.checkifuserisfollowed(id);
        if (followersList.isEmpty()) {
            return true;
        }
        else return false;
    }
    public List<Followers> followers_id(long id) {
        List<Followers> followersList = new ArrayList<>();
        followersRepository.checkifuserisfollowed(id).forEach(followersList::add);
        return followersList;
    }
}
