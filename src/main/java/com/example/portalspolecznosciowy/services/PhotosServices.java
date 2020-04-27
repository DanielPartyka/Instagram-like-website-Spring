package com.example.portalspolecznosciowy.services;

import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.repositories.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotosServices {

    @Autowired
    PhotosRepository photosRepository;

    public long howManyPhotos(long id) {
        return photosRepository.findHowManyPhotos(id);
    }

    public Photos findPhotoDetails(long photo_id) {
        Photos photos = photosRepository.findPhotoDetails(photo_id);
        return photos;
    }
}
