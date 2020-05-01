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

    //Pobierz uzytkownikow, ktorych nie followuje zalogowany user bez siebie
    @Query(value = "Select * from user u where not u.email=?1 and u.id not in (Select f.follower_id from followers f, user u where f.user_id = u.id)", nativeQuery = true)
    List<User> getAllUsertoFollow(String email);

    @Query(value = "select * from user where email =?1", nativeQuery = true)
    User findIdByEmail(String email);

    // Ile osob followuje dany uzytkownik
    @Query(value = "Select Count(f.follower_id) from user u, followers f where u.id = f.user_id and u.id = ?1", nativeQuery = true)
    long HowManyUserisFollwing(Long id);

    // Ile osob followuje tego uzytkownika
    @Query(value = "Select Count(u.id) from user u, followers f where u.id = f.user_id and f.follower_id = ?1" , nativeQuery = true)
    long HowManyUsersFollwsCurrentUser(Long id);

    @Query(value = "select * from user where email =?1", nativeQuery = true)
    User findIdByEmailLong(String email);

    @Query(value = "select * from user where nickname=?1",nativeQuery = true)
    User findByNickname(String nickname);

    @Query(value = "select u.nickname from user u,comments c where u.id = c.user_id and c.comment_id=?1",nativeQuery = true)
    String findUserNicknameById(long id);

    @Query(value = "select * from user u where u.name like %?1%", nativeQuery = true)
    List<User> findUserbyQuery(String query);

}
