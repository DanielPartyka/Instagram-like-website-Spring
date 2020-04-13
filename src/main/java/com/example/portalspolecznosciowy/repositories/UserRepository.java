package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findById(long id);
}
