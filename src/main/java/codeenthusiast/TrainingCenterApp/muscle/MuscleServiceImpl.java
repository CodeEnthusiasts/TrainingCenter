package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyExistsException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import org.springframework.stereotype.Service;
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

    private Muscle findEntityById(Long id) {
        return muscleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    @Override
    public List<MuscleDTO> findByMovementId(Long id) {
        List<Muscle> muscleList = muscleRepository.findByMovementId(id);
        return muscleMapper.mapToDTOs(muscleList);
    }

    @Override
    public MuscleDTO update(Long id, MuscleDTO dto) {
        this.isExistsById(id);
        dto.setId(id);
        return save(dto);
    }

    @Override
    public MuscleDTO create(MuscleDTO dto) {
        checkExistenceByName(dto.getName());
        Muscle muscle = new Muscle(dto);
        return save(muscleMapper.mapToDTO(muscle));
    }

    @Override
    public MuscleDTO save(MuscleDTO dto) {
        Muscle muscle = muscleMapper.mapToEntity(dto);

        return muscleMapper.mapToDTO(muscleRepository.save(muscle));
    }

    @Override
    public void deleteById(Long id) {
        if (isExistsById(id)) {
            muscleRepository.deleteById(id);
        }
    }

    @Override
    public boolean isExistsById(Long id) {
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
    public MuscleDTO addImage(Long id, MultipartFile file) {
        Muscle muscle = findEntityById(id);
        imageService.createNewImage(file, muscle);
        return muscleMapper.mapToDTO(muscle);
    }

    @Override
    public MuscleDTO removeAllImages(Long id) {
        imageService.deleteImagesByMuscleId(id);
        return findById(id);

    }

}
