package com.example.portalspolecznosciowy.services;

import com.example.portalspolecznosciowy.models.Comments;
import com.example.portalspolecznosciowy.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServices {

    @Autowired
    CommentsRepository commentsRepository;

    public List<Comments> getPhotoDetailById(long id) {
        List<Comments> comments = new ArrayList<>();
        commentsRepository.getPhotoDetailsById(id).forEach(comments::add);
        return comments;
    }

    public String getUserNicknameById(long id) {
        return commentsRepository.getUserNicknameById(id);
    }
}
