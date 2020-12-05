package codeenthusiast.TrainingCenterApp.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadImageOnHosting(MultipartFile file);

    void createNewImage(MultipartFile file, Object object);

    boolean existsByUserId(Long userId);

    ImageDTO save(Image dto);

    void replaceImage(Image image, MultipartFile file);

    void deleteImagesByMovementId(Long id);

    void deleteImagesByMuscleId(Long id);

    void deleteImageByUserId(Long id);



}
