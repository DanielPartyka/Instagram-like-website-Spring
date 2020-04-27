package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.Photos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends CrudRepository<Photos,Long> {
    @Query(value = "Select Count(p.photo_id) from photos p, user u where u.id = p.user_id and user_id=?1", nativeQuery = true)
    Long findHowManyPhotos(long user_id);

    @Query(value = "Select * from photos p where p.photo_id = ?1", nativeQuery = true)
    Photos findPhotoDetails(long photo_id);
}
