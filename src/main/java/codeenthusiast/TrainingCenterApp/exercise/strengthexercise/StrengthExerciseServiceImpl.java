package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementServiceImpl;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrengthExerciseServiceImpl implements StrengthExerciseService, SecurityService {

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

    public StrengthExercise getStrengthExerciseById(long id) {
        return strengthExerciseRepository.findById(id);
    }

    @Override
    public StrengthExercise findEntityById(Long id) {
        StrengthExercise strengthExercise = strengthExerciseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        authorize(hasAccess(strengthExercise));
        return strengthExercise;
    }

    @Override
    public StrengthExerciseDTO findById(Long id) {
        StrengthExercise strengthExercise = findEntityById(id);
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


    private StrengthExerciseDTO save(StrengthExercise oldExercise) {
        StrengthExercise strengthExercise = strengthExerciseRepository.save(oldExercise);
        return strengthExerciseMapper.mapToDTO(strengthExercise);
    }

    @Override
    public List<StrengthExerciseDTO> getAllByTrainingSessionId(Long trainingSessionId) {
        trainingSessionService.findEntityById(trainingSessionId);
        List<StrengthExercise> strengthExercises = strengthExerciseRepository.findAllByTrainingSessionId(trainingSessionId);
        return strengthExerciseMapper.mapToDTOs(strengthExercises);
    }

    @Override
    public StrengthExerciseDTO update(Long id, StrengthExerciseDTO dto) {
        StrengthExercise oldExercise = findEntityById(id);
        updateData(dto, oldExercise);

        return save(oldExercise);
    }

    public void updateData(StrengthExerciseDTO dto, StrengthExercise oldExercise) {
        oldExercise.setRepetitionUnit(dto.getRepetitionUnit());
        oldExercise.setReps(dto.getReps());
        oldExercise.setWeight(dto.getWeight());
        oldExercise.setWeightUnit(dto.getWeightUnit());
    }


    @Override
    public StrengthExerciseDTO create(StrengthExerciseDTO dto, Long trainingSessionId, Long movementId) {
        StrengthExercise strengthExercise = new StrengthExercise(dto);
        return save(strengthExercise, trainingSessionId, movementId);
    }


    @Override
    public void deleteById(Long id) {
        findEntityById(id);
        strengthExerciseRepository.deleteById(id);
    }

    private boolean hasAccess(StrengthExercise strengthExercise) {
        return strengthExercise.getTrainingSession().getTrainingPlan().getUser().getId().equals(getPrincipal().getId());
    }

}
