package codeenthusiast.TrainingCenterApp.image;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    ImageDTO createNewImage(MultipartFile file);

    String uploadImageOnHosting(MultipartFile file);

    ImageDTO save(ImageDTO dto);

    void deleteImagesById(List<Long> images);
}
