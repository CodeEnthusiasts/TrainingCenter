package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.mappers.StrengthExerciseMapper;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import codeenthusiast.TrainingCenterApp.muscle.MuscleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrengthExerciseServiceImpl implements StrengthExerciseService {

    private final StrengthExerciseRepository strengthExerciseRepository;

    private final StrengthExerciseMapper strengthExerciseMapper;

    public StrengthExerciseServiceImpl(StrengthExerciseRepository strengthExerciseRepository, StrengthExerciseMapper strengthExerciseMapper) {
        this.strengthExerciseRepository = strengthExerciseRepository;
        this.strengthExerciseMapper = strengthExerciseMapper;
    }

    @Override
    public StrengthExerciseDTO findById(Long id) {
        StrengthExercise strengthExercise = strengthExerciseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        return strengthExerciseMapper.mapToDTO(strengthExercise);
    }

    @Override
    public StrengthExerciseDTO save(StrengthExerciseDTO dto) {
        StrengthExercise muscle = strengthExerciseMapper.mapToEntity(dto);
        strengthExerciseRepository.save(muscle);
        return dto;
    }

    @Override
    public List<StrengthExerciseDTO> getAllByTrainingSessionId(Long id) {
        List<StrengthExercise> listOfExercises = strengthExerciseRepository.findAllByTrainingSessionId(id);
        return strengthExerciseMapper.mapToDTOs(listOfExercises);
    }

    @Override
    public StrengthExerciseDTO update(Long id, StrengthExerciseDTO dto) {
        dto.setId(id);
        return save(dto);
    }

    @Override
    public StrengthExerciseDTO create(StrengthExerciseDTO dto) {
        StrengthExercise strengthExercise = new StrengthExercise(dto);
        return strengthExerciseMapper.mapToDTO(strengthExercise);
    }


    @Override
    public void deleteById(Long id) {
        strengthExerciseRepository.deleteById(id);
    }
}
