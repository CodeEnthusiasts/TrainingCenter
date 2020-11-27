package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementServiceImpl;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrengthExerciseServiceImpl implements StrengthExerciseService {

    private final StrengthExerciseRepository strengthExerciseRepository;

    private final TrainingSessionServiceImpl trainingSessionService;

    private final MovementServiceImpl movementService;

    private final StrengthExerciseMapper strengthExerciseMapper;

    public StrengthExerciseServiceImpl(StrengthExerciseRepository strengthExerciseRepository, TrainingSessionServiceImpl trainingSessionService, MovementServiceImpl movementService, StrengthExerciseMapper strengthExerciseMapper) {
        this.strengthExerciseRepository = strengthExerciseRepository;
        this.trainingSessionService = trainingSessionService;
        this.movementService = movementService;
        this.strengthExerciseMapper = strengthExerciseMapper;
    }

    @Override
    public StrengthExerciseDTO findById(Long id) {
        StrengthExercise strengthExercise = strengthExerciseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        return strengthExerciseMapper.mapToDTO(strengthExercise);
    }

    @Override
    public StrengthExerciseDTO save(StrengthExercise strengthExercise, Long trainingSessionId, Long movementId) {

        TrainingSession trainingSession = trainingSessionService.findEntityById(trainingSessionId);
        Movement movement = movementService.findEntityById(movementId);

        strengthExercise.setMovement(movement);
        strengthExercise.setTrainingSession(trainingSession);

        StrengthExercise result = strengthExerciseRepository.save(strengthExercise);

        return strengthExerciseMapper.mapToDTO(result);
    }

    private StrengthExerciseDTO save(StrengthExerciseDTO oldExercise) {
        StrengthExercise entity = strengthExerciseMapper.mapToEntity(oldExercise);

        return strengthExerciseMapper.mapToDTO(strengthExerciseRepository.save(entity));
    }

    @Override
    public List<StrengthExerciseDTO> getAllByTrainingSessionId(Long id) {
        List<StrengthExercise> listOfExercises = strengthExerciseRepository.findAllByTrainingSessionId(id);
        return strengthExerciseMapper.mapToDTOs(listOfExercises);
    }

    @Override
    public StrengthExerciseDTO update(Long id, StrengthExerciseDTO dto) {

        StrengthExerciseDTO oldExercise = findById(id);
        oldExercise.setRepetitionUnit(dto.getRepetitionUnit());
        oldExercise.setReps(dto.getReps());
        oldExercise.setStrengthExerciseDetails(dto.getStrengthExerciseDetails());
        oldExercise.setWeight(dto.getWeight());
        oldExercise.setWeightUnit(dto.getWeightUnit());
        return save(oldExercise);
    }


    @Override
    public StrengthExerciseDTO create(StrengthExerciseDTO dto, Long trainingPlanId, Long movementId) {
        StrengthExercise strengthExercise = new StrengthExercise(dto);
        save(strengthExercise, trainingPlanId, movementId);
        return strengthExerciseMapper.mapToDTO(strengthExercise);
    }


    @Override
    public void deleteById(Long id) {
        strengthExerciseRepository.deleteById(id);
    }
}
