package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyExistsException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuscleServiceImpl implements MuscleService {

    private final MuscleRepository muscleRepository;

    private final MuscleMapper muscleMapper;

    public MuscleServiceImpl(MuscleRepository muscleRepository, MuscleMapper muscleMapper) {
        this.muscleRepository = muscleRepository;
        this.muscleMapper = muscleMapper;
    }

    @Override
    public void deleteById(Long id) {
        checkExistence(id);
        muscleRepository.deleteById(id);
    }

    @Override
    public void checkExistence(Long id) {
        if (!muscleRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void checkExistenceByName(String name) {

        if (muscleRepository.existsByName(name)) {
            throw new EntityAlreadyExistsException(name);
        }
    }

    @Override
    public MuscleDTO findById(Long id) {
        Muscle muscle = muscleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        return muscleMapper.mapToDTO(muscle);
    }

    @Override
    public List<MuscleDTO> findByMovementId(Long id) {
        List<Muscle> muscleList = muscleRepository.findByMovementId(id);
        return muscleMapper.mapToDTOs(muscleList);
    }

    @Override
    public MuscleDTO update(Long id, MuscleDTO dto) {
        checkExistence(id);
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
    public MuscleDTO addImage(Long id, ImageDTO image) {
        MuscleDTO muscle = findById(id);
        muscle.getImages().add(image);
        return save(muscle);
    }

    @Override
    public List<Long> removeAllImages(Long id) {
        MuscleDTO muscle = findById(id);
        List<Long> idList = getIdOfDeletedImages(muscle.getImages());
        muscle.getImages().clear();
        save(muscle);

        return idList;
    }

    @Override
    public List<Long> getIdOfDeletedImages(List<ImageDTO> images) {
        return images.stream()
                .map(AbstractDTO::getId)
                .collect(Collectors.toList());
    }

}
