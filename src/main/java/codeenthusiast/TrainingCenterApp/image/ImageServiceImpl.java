package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementDTO;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import codeenthusiast.TrainingCenterApp.user.major.User;
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

    public boolean existsByUserId(Long userId){
        return repository.existsByUserId(userId);
    }


    @Override
    public ImageDTO createNewImage(MultipartFile file) {
        String fileUrl = uploadImageOnHosting(file);
        Image image = new Image(fileUrl);
        return save(image);
    }

    public ImageDTO save(Image image) {
        Image savedImaged = repository.save(image);
        return imageMapper.mapToDTO(savedImaged);
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


    public void createNewMovementImage(MultipartFile file, Movement movement) {
        String fileUrl = uploadImageOnHosting(file);
        Image image = new Image(fileUrl, movement);
        save(image);
    }

    public void deleteImagesByMovementId(Long id) {
        repository.deleteByMovementId(id);
    }

    public void createNewMuscleImage(MultipartFile file, Muscle muscle) {
        String fileUrl = uploadImageOnHosting(file);
        Image image = new Image(fileUrl, muscle);
        save(image);
    }

    public void deleteImagesByMuscleId(Long id){
        repository.deleteByMuscleId(id);
    }

    public void createNewUserImage(User user, MultipartFile file) {
        String fileUrl = uploadImageOnHosting(file);
        Image image = new Image(fileUrl, user);
        save(image);
    }

    public void deleteImagesByUserId(Long id) {
        repository.deleteByUserId(id);
    }

    public void replaceUserImage(Image image, MultipartFile file) {
        String fileUrl = uploadImageOnHosting(file);
        image.setFileUrl(fileUrl);
        save(image);
    }
}
