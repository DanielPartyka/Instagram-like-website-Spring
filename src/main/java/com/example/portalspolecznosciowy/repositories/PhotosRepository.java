package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.Photos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends CrudRepository<Photos,Long> {

}
