package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyFoundException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;

import codeenthusiast.TrainingCenterApp.image.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuscleService {

    private final ModelMapper modelMapper = new ModelMapper();

    private final MuscleRepository muscleRepository;

    private final ImageService imageService;

    public MuscleService(MuscleRepository muscleRepository, ImageService imageService) {
        this.muscleRepository = muscleRepository;
        this.imageService = imageService;
    }

    public MuscleDTO mapToMuscleDTO(Muscle muscle) {
        return modelMapper.map(muscle, MuscleDTO.class);
    }

    public Muscle mapToMuscle(MuscleDTO muscleDTO) {
        return modelMapper.map(muscleDTO, Muscle.class);
    }

    public boolean existsByName(String name) {
        return muscleRepository.existsByName(name);
    }

    public boolean existsById(Long id) {
        return muscleRepository.existsById(id);
    }

    public List<MuscleDTO> getAllMuscles() {
        return muscleRepository.findAll().stream()
                .map(this::mapToMuscleDTO)
                .collect(Collectors.toList());
    }

    public MuscleDTO getMuscle(Long id) {
        Muscle muscle = muscleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        return mapToMuscleDTO(muscle);
    }

    public Muscle getMuscleEntity(Long id) {
        return muscleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    public MuscleDTO createMuscle(MuscleDTO muscleDTO) {
        String name = muscleDTO.getName();

        if (existsByName(name)) {
            throw new EntityAlreadyFoundException(name);
        }

        Muscle muscle = mapToMuscle(muscleDTO);
        Muscle createdMuscle = new Muscle(muscle);
        muscleRepository.save(createdMuscle);
        return muscleDTO;
    }

    public void deleteMuscle(Long id) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(id);
        } else {
            muscleRepository.deleteById(id);
        }
    }

    public MuscleDTO updateMuscle(Long id, MuscleDTO muscleDTO) {
        validateUpdate(id, muscleDTO);

        Muscle updatedMuscle = mapToMuscle(muscleDTO);
            updatedMuscle.setId(id);
            muscleRepository.save(updatedMuscle);
        return muscleDTO;
    }

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
        Muscle muscle = getMuscleEntity(id);
        Image image = imageService.createNewImage(filePath);
        addImage(muscle, image);
        muscleRepository.save(muscle);

        return mapToMuscleDTO(muscle);
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
    }
}
