package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.mappers.ImageMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImpl extends AbstractServiceImpl<Image, ImageDTO> implements ImageService {

    private final ImageRepository repository;
    private final ImageMapper mapper;
    private final ImageUploader imageUploader;

    public ImageServiceImpl(AbstractRepository<Image> reposiotory, AbstractMapper<Image, ImageDTO> mapper, ImageRepository repository, ImageMapper mapper1, ImageUploader imageUploader) {
        super(reposiotory, mapper);
        this.repository = repository;
        this.mapper = mapper1;
        this.imageUploader = imageUploader;
    }


    @Override
    public String uploadImageOnHosting(MultipartFile file) {
        return imageUploader.uploadImage(file);
    }

    @Override
    public ImageDTO createNewImageDTO(MultipartFile file) {
        String fileUrl = uploadImageOnHosting(file);
        return new ImageDTO(fileUrl);
    }

    @Override
    public ImageDTO saveImage(MultipartFile file){
        ImageDTO image = createNewImageDTO(file);
        return save(image);
    }


}
