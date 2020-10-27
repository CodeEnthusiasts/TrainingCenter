package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;

public interface ImageService extends AbstractService<Image, ImageDTO> {

    //todo add Cloudinary api here and adding img methods.
    Image createNewImage(String filePath);

    Image findByFileUrl(String fileUrl);

}
