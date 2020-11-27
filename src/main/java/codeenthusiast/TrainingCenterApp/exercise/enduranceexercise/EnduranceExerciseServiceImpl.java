package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.mappers.EnduranceExerciseMapper;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementServiceImpl;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnduranceExerciseServiceImpl implements EnduranceExerciseService {

    private final EnduranceExerciseRepository enduranceExerciseRepository;

    private final TrainingSessionServiceImpl trainingSessionService;

    private final MovementServiceImpl movementService;

    private final EnduranceExerciseMapper enduranceExerciseMapper;

    public EnduranceExerciseServiceImpl(EnduranceExerciseRepository enduranceExerciseRepository,
                                        TrainingSessionServiceImpl trainingSessionService, MovementServiceImpl movementService, EnduranceExerciseMapper enduranceExerciseMapper) {
        this.enduranceExerciseRepository = enduranceExerciseRepository;
        this.trainingSessionService = trainingSessionService;
        this.movementService = movementService;
        this.enduranceExerciseMapper = enduranceExerciseMapper;
    }

    @Override
    public EnduranceExerciseDTO findById(Long id) {
        EnduranceExercise enduranceExercise = enduranceExerciseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        return enduranceExerciseMapper.mapToDTO(enduranceExercise);
    }

    @Override
    public EnduranceExerciseDTO save(EnduranceExercise enduranceExercise, Long trainingPlanId, Long movementId) {

        TrainingSession trainingSession = trainingSessionService.findEntityById(trainingPlanId);
        Movement movement = movementService.findEntityById(movementId);

        enduranceExercise.setMovement(movement);
        enduranceExercise.setTrainingSession(trainingSession);

        EnduranceExercise result = enduranceExerciseRepository.save(enduranceExercise);

        return enduranceExerciseMapper.mapToDTO(result);
    }

    private EnduranceExerciseDTO save(EnduranceExerciseDTO oldExercise) {
        EnduranceExercise entity = enduranceExerciseMapper.mapToEntity(oldExercise);

        return enduranceExerciseMapper.mapToDTO(enduranceExerciseRepository.save(entity));
    }

    @Override
    public List<EnduranceExerciseDTO> getAllByTrainingSessionId(Long id) {
        List<EnduranceExercise> listOfExercises = enduranceExerciseRepository.findAllByTrainingSessionId(id);
        return enduranceExerciseMapper.mapToDTOs(listOfExercises);
    }

    @Override
    public EnduranceExerciseDTO update(Long id, EnduranceExerciseDTO dto) {

        EnduranceExerciseDTO oldExercise = findById(id);
        oldExercise.setDistance(dto.getDistance());
        oldExercise.setDistanceUnit(dto.getDistanceUnit());
        oldExercise.setEnduranceExerciseDetails(dto.getEnduranceExerciseDetails());
        oldExercise.setDuration(dto.getDuration());
        oldExercise.setTimeUnit(dto.getTimeUnit());
        return save(oldExercise);
    }


    @Override
    public EnduranceExerciseDTO create(EnduranceExerciseDTO dto, Long trainingSessionId, Long movementId) {
        EnduranceExercise enduranceExercise = new EnduranceExercise(dto);
        save(enduranceExercise, trainingSessionId, movementId);
        return enduranceExerciseMapper.mapToDTO(enduranceExercise);
    }


    @Override
    public void deleteById(Long id) {
        enduranceExerciseRepository.deleteById(id);
    }
}
