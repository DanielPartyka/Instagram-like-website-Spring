package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.Followers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowersRepository extends CrudRepository<Followers, Long> {

    @Query(value = "Select * from followers f where user_id=?1", nativeQuery = true)
    List<Followers> checkifuserisfollowed(long user_id);
}
