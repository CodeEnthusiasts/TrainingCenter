package codeenthusiast.TrainingCenterApp.services;

import codeenthusiast.TrainingCenterApp.entities.Image;
import codeenthusiast.TrainingCenterApp.repositories.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    //todo add Cloudinary api here and adding img methods.

    public Image createNewImage(String filePath) {
        return new Image();
    }

    public Image findByFileUrl(String fileUrl) {
        return new Image();
    }


}
