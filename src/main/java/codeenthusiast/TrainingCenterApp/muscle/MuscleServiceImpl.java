package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyExistsException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MuscleServiceImpl implements MuscleService {

    private final MuscleRepository muscleRepository;

    private final ImageServiceImpl imageService;

    private final MuscleMapper muscleMapper;

    public MuscleServiceImpl(MuscleRepository muscleRepository, ImageServiceImpl imageService, MuscleMapper muscleMapper) {
        this.muscleRepository = muscleRepository;
        this.imageService = imageService;
        this.muscleMapper = muscleMapper;
    }

    @Override
    public MuscleDTO findById(Long id) {
        Muscle muscle = findEntityById(id);
        return muscleMapper.mapToDTO(muscle);
    }

    @Override
    public Muscle findEntityById(Long id) {
        return muscleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    @Override
    public List<MuscleDTO> findByMovementId(Long id) {
        List<Muscle> muscleList = muscleRepository.findByMovementId(id);
        return muscleMapper.mapToDTOs(muscleList);
    }

    @Override
    @Transactional
    public MuscleDTO update(Long id, MuscleDTO dto) {
        this.existsById(id);
        dto.setId(id);
        Muscle updatedMuscle = muscleMapper.mapToEntity(dto);
        return muscleMapper.mapToDTO(updatedMuscle);
    }

    @Override
    @Transactional
    public MuscleDTO create(MuscleDTO dto) {
        checkExistenceByName(dto.getName());
        Muscle muscle = new Muscle(dto);
        return save(muscle);
    }

    @Override
    public MuscleDTO save(Muscle muscle) {
        Muscle savedMuscle = muscleRepository.save(muscle);
        return muscleMapper.mapToDTO(savedMuscle);
    }

    @Override
    public void deleteById(Long id) {
        if (existsById(id)) {
            muscleRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        if (!muscleRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        return true;
    }

    @Override
    public void checkExistenceByName(String name) {

        if (muscleRepository.existsByName(name)) {
            throw new EntityAlreadyExistsException(name);
        }
    }

    @Override
    @Transactional
    public MuscleDTO addImage(Long id, MultipartFile file) {
        Muscle muscle = findEntityById(id);
        imageService.createNewImage(file, muscle);
        return muscleMapper.mapToDTO(muscle);
    }

    @Override
    @Transactional
    public MuscleDTO removeAllImages(Long id) {
        imageService.deleteImagesByMuscleId(id);
        return findById(id);

    }

}
