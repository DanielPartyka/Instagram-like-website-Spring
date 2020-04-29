package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.Comments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends CrudRepository<Comments,Long> {

    @Query(value = "select c.comment_id,c.description,c.date from comments c, photos p where p.photo_id = c.photo_id and c.photo_id =?1", nativeQuery=true)
    List<Comments> getPhotoDetailsById(long user_id);

    @Query(value = "select u.nickname from user u, comments c where u.id = c.user_id and c.comment_id = ?1", nativeQuery = true)
    String getUserNicknameById(long comment_id);
}
