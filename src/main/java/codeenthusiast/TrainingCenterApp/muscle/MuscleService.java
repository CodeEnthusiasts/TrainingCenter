package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyExistsException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.mappers.MuscleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuscleService {

    private final MuscleRepository muscleRepository;

    private final MuscleMapper muscleMapper;

    public MuscleService(MuscleRepository muscleRepository, MuscleMapper muscleMapper) {
        this.muscleRepository = muscleRepository;
        this.muscleMapper = muscleMapper;
    }

    public void deleteById(Long id) {
        if(!muscleRepository.existsById(id)){
            throw new EntityNotFoundException(id);
        }
        muscleRepository.deleteById(id);
    }

    public MuscleDTO findById(Long id) {
        Muscle muscle = muscleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        return muscleMapper.mapToDTO(muscle);
    }

    public MuscleDTO update(Long id, MuscleDTO dto) {

        if(!muscleRepository.existsById(id)){
            throw new EntityNotFoundException(id);
        }

        dto.setId(id);
        return save(dto);
    }

    public MuscleDTO create (MuscleDTO dto){
        String name = dto.getName();
        if(muscleRepository.existsByName(name)){
            throw new EntityAlreadyExistsException(name);
        } else {
            Muscle muscle = new Muscle(dto);
            return muscleMapper.mapToDTO(muscle);
        }

    }
    public MuscleDTO save(MuscleDTO dto) {
        Muscle muscle = muscleMapper.mapToEntity(dto);
        muscleRepository.save(muscle);
        return dto;
    }

    public MuscleDTO addImage(Long id, ImageDTO image) {
        MuscleDTO muscle = findById(id);

        muscle.getImages().add(image);

        return save(muscle);
    }

    public List<Long> removeAllImages(Long id) {
        MuscleDTO muscle = findById(id);

        List<Long> idList = muscle.getImages().stream()
                .map(AbstractDTO::getId)
                .collect(Collectors.toList());

        muscle.getImages().clear();

        save(muscle);

        return idList;
    }

    public List<ImageDTO> findImages(Long id){
        MuscleDTO m = findById(id);
        return m.getImages();
    }
}
