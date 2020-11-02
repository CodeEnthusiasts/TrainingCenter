package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ImageService extends AbstractService<Image, ImageDTO> {

     String uploadImageOnHosting(MultipartFile file);

     ImageDTO createNewImageDTO(MultipartFile file);

     ImageDTO saveImage(MultipartFile file);
}
