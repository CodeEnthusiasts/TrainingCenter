package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.mappers.MuscleMapper;
import org.springframework.stereotype.Service;

@Service
public class MuscleServiceImpl extends AbstractServiceImpl<Muscle, MuscleDTO> implements MuscleService {

    private final MuscleRepository repository;
    private final MuscleMapper mapper;


    public MuscleServiceImpl(AbstractRepository<Muscle> repository, AbstractMapper<Muscle, MuscleDTO> mapper, MuscleRepository repository1, MuscleMapper mapper1) {
        super(repository, mapper);
        this.repository = repository1;
        this.mapper = mapper1;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public MuscleDTO addImageToMuscle(Long id, String filePath) {
        return null;
    }

    @Override
    public void addImage(Muscle muscle, Image image) {

    }

    @Override
    public void deleteImageFromMuscle(Long id, String fileUrl) {

    }

    @Override
    public void removeImage(Muscle muscle, Image image) {

    }

    @Override
    public void removeAllImages(Muscle muscle) {

    }
    /*





    void validateUpdate(Long id, MuscleDTO muscleDTO) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        String name = muscleDTO.getName();
        if (existsByName(name)) {
            throw new EntityAlreadyFoundException(name);
        }
    }

    public MuscleDTO addImageToMuscle(Long id, String filePath) {

    }

    private void addImage(Muscle muscle, Image image) {
        muscle.addImage(image);
    }

    public void deleteImageFromMuscle(Long id, String fileUrl) {
        Muscle muscle = getMuscleEntity(id);
        Image image = imageService.findByFileUrl(fileUrl);
        removeImage(muscle, image);
        muscleRepository.save(muscle);

    }

    private void removeImage(Muscle muscle, Image image) {
        muscle.removeImage(image);
    }

    public void deleteAllImagesFromMuscle(Long id) {
        Muscle muscle = getMuscleEntity(id);
        removeAllImages(muscle);
        muscleRepository.save(muscle);
    }

    private void removeAllImages(Muscle muscle) {
        muscle.removeAllImages();
    }*/
}
