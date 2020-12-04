package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import codeenthusiast.TrainingCenterApp.user.major.User;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public boolean existsByUserId(Long userId) {
        return repository.existsByUserId(userId);
    }

    @Override
    public ImageDTO save(Image image) {
        Image savedImaged = repository.save(image);
        return imageMapper.mapToDTO(savedImaged);
    }

    @Override
    public String uploadImageOnHosting(MultipartFile file) {
        return imageUploader.uploadImage(file);
    }

    @Override
    public void createNewImage(MultipartFile file, Object object) {
        String fileUrl = uploadImageOnHosting(file);
        Class<?> classType = object.getClass();
        Image image = null;
        if (classType.equals(Movement.class)) {
            image = new Image(fileUrl, (Movement) object);
        } else if (classType.equals(Muscle.class)) {
            image = new Image(fileUrl, (Muscle) object);
        } else if (classType.equals(User.class)) {
            image = new Image(fileUrl, (User) object);
        }
        save(image);
    }

    @Override
    public void replaceImage(Image image, MultipartFile file) {
        String fileUrl = uploadImageOnHosting(file);
        image.setFileUrl(fileUrl);
        save(image);
    }

    @Override
    public void deleteImagesByMovementId(Long id) {
        repository.deleteByMovementId(id);

    }

    @Override
    public void deleteImagesByMuscleId(Long id) {
        repository.deleteByMuscleId(id);
    }

    @Override
    public void deleteImageByUserId(Long id) {
        repository.deleteByUserId(id);
    }

}
