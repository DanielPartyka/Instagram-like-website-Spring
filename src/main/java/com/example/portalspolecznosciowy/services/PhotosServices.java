package com.example.portalspolecznosciowy.services;

import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.repositories.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<Photos> getAmountofPhotos(long id) {
        List<Photos> photos = new ArrayList<Photos>();
        photosRepository.getAmountofPhotos(id).forEach(photos::add);
        return photos;
    }
    public Photos getPhotoDetailsById(long id) {
        Photos photos = photosRepository.findPhotoDetailsById(id);
        return photos;
    }


}
