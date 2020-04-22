package com.example.portalspolecznosciowy.services;

import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotosServices {

    @Autowired
    PhotosRepository photosRepository;

    public Photos howManyPhotos(long id) {
        Photos photos = photosRepository.findHowManyPhotos(id);
        return photos;
    }
}
