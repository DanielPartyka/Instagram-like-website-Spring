package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.Followers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowersRepository extends CrudRepository<Followers, Long> {

}
