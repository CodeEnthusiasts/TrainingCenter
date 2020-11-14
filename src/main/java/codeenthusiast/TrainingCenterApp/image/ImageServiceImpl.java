package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.mappers.ImageMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public ImageDTO createNewImage(MultipartFile file){
        String fileUrl = uploadImageOnHosting(file);
        ImageDTO image = new ImageDTO(fileUrl);
        return save(image);
    }

    @Override
    public String uploadImageOnHosting(MultipartFile file) {
        return imageUploader.uploadImage(file);
    }

    public void deleteImagesById(List<Long> idImages){
        for(int i = 0; i < idImages.size(); i++){
            repository.deleteById(idImages.get(i));
        }
    }










}
