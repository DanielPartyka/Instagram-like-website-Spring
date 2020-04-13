package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotosRepository extends CrudRepository<Photos, Long> {
    List<Photos> findbyUser(User user, Sort sort);
}
