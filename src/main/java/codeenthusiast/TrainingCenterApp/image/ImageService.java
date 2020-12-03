package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.movement.Movement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    String uploadImageOnHosting(MultipartFile file);

    void createNewImage(MultipartFile file, Object object);

    boolean existsByUserId(Long userId);

    ImageDTO save(Image dto);

}
