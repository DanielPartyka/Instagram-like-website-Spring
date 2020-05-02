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
    public long findUserByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname);
        return user.getId();
    }
    public User findUserObjbyNickname(String nickname) {
        User user = userRepository.findByNickname(nickname);
        return user;
    }
    public List<User> proponowaniUzytkownicy(String email) {
        List<User> users = new ArrayList<User>();
        userRepository.getAllUsertoFollow(email).forEach(users::add);
        return users;
    }

    public List<User> wszyscyUzytkownicy() {
        List<User> users = new ArrayList<User>();
        userRepository.getAllUsers().forEach(users::add);
        return users;
    }
    public List<User> findUsersByQuery(String q) {
        List<User> users = new ArrayList<User>();
        userRepository.findUserbyQuery(q).forEach(users::add);
        return users;
    }
    public String findUserNicknameByPhotoId(long id) {
        return  userRepository.findUserNicknameByPhotoId(id);
    }
    public User getAllUsersById(long id) {
        User user = userRepository.getAllUsersById(id);
        return user;
    }
}
