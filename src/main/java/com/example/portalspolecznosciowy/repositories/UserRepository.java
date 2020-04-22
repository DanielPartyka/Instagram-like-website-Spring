package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query(value = "select * from user where email = ?1 or nickname=?2", nativeQuery = true)
    User findByEmailorNickname(String email, String nickname);

    @Query(value = "select * from user", nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "select * from user where email =?1", nativeQuery = true)
    User findIdByEmail(String email);
}
