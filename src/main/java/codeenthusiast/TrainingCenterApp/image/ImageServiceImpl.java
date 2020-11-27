package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.mappers.ImageMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;
    private final ImageMapper imageMapper;
    private final ImageUploader imageUploader;

    public ImageServiceImpl(ImageRepository repository,
                            ImageMapper imageMapper, ImageUploader imageUploader) {
        this.repository = repository;
        this.imageMapper = imageMapper;
        this.imageUploader = imageUploader;
    }


    @Override
    public ImageDTO createNewImage(MultipartFile file) {
        String fileUrl = uploadImageOnHosting(file);
        ImageDTO image = new ImageDTO(fileUrl);
        return save(image);
    }

    public ImageDTO save(ImageDTO dto) {
        Image image = imageMapper.mapToEntity(dto);
        repository.save(image);
        return dto;
    }

    @Override
    public String uploadImageOnHosting(MultipartFile file) {
        return imageUploader.uploadImage(file);
    }

    public void deleteImagesById(List<Long> idImages) {
        for (Long idImage : idImages) {
            repository.deleteById(idImage);
        }
    }


}
