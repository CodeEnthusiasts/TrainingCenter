package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService extends AbstractService<Image, ImageDTO> {

     ImageDTO createNewImage(MultipartFile file);

     String uploadImageOnHosting(MultipartFile file);

}
