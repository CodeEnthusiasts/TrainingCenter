package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementServiceImpl;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnduranceExerciseServiceImpl implements EnduranceExerciseService, SecurityService {

    private final EnduranceExerciseRepository repository;

    private final EnduranceExerciseMapper mapper;

    private final TrainingSessionServiceImpl trainingSessionService;

    private final MovementServiceImpl movementService;

    public EnduranceExerciseServiceImpl(EnduranceExerciseRepository repository,
                                        EnduranceExerciseMapper mapper,
                                        TrainingSessionServiceImpl trainingSessionService,
                                        MovementServiceImpl movementService) {
        this.repository = repository;
        this.mapper = mapper;
        this.trainingSessionService = trainingSessionService;
        this.movementService = movementService;
    }

    @Override
    public EnduranceExercise getEnduranceExerciseEntityById(Long id) {
        EnduranceExercise enduranceExercise = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(enduranceExercise));
        return enduranceExercise ;
    }

    @Override
    public EnduranceExerciseDTO getEnduranceExerciseById(Long enduranceExerciseId) {
        return mapToDTO(getEnduranceExerciseEntityById(enduranceExerciseId));
    }

    @Override
    @Transactional
    public EnduranceExerciseDTO createEnduranceExercise(EnduranceExerciseDTO dto,
                                                        Long trainingSessionId,
                                                        Long movementId) {
        TrainingSession trainingSession = trainingSessionService.getTrainingSessionEntityById(trainingSessionId);
        Movement movement = movementService.findEntityById(movementId);
        EnduranceExercise enduranceExercise = mapToEntity(dto);
        enduranceExercise.setMovement(movement);
        enduranceExercise.setTrainingSession(trainingSession);
        return mapToDTO(save(enduranceExercise));
    }

    @Override
    @Transactional
    public EnduranceExerciseDTO updateEnduranceExercise(Long enduranceExerciseId,
                                                        EnduranceExerciseDTO dto) {
        EnduranceExercise enduranceExercise = getEnduranceExerciseEntityById(enduranceExerciseId);
        updateEnduranceExercise(enduranceExercise, dto);
        return mapToDTO(enduranceExercise);
    }

    @Override
    public List<EnduranceExerciseDTO> getAllEnduranceExercisesByTrainingSessionId(Long trainingSessionId) {
        TrainingSession trainingSession = trainingSessionService.getTrainingSessionEntityById(trainingSessionId);
        return mapToDTOs(trainingSession.getEnduranceExercises());
    }

    @Override
    public String deleteEnduranceExercise(Long enduranceExerciseId) {
        repository.delete(getEnduranceExerciseEntityById(enduranceExerciseId));
        return "Exercise deleted successfully. ";
    }

    private boolean hasAccess(EnduranceExercise enduranceExercise) {
        return enduranceExercise.getTrainingSession()
                                .getTrainingPlan()
                                .getUser()
                                .getId()
                                .equals(getPrincipal().getId());
    }

    private EnduranceExercise save(EnduranceExercise enduranceExercise) {
        return repository.save(enduranceExercise);
    }

    private void updateEnduranceExercise(EnduranceExercise enduranceExercise,
                                         EnduranceExerciseDTO enduranceExerciseDTO) {
        enduranceExercise.setDistanceUnit(enduranceExerciseDTO.getDistanceUnit());
        enduranceExercise.setDistance(enduranceExerciseDTO.getDistance());
        enduranceExercise.setTimeUnit(enduranceExerciseDTO.getTimeUnit());
        enduranceExercise.setDuration(enduranceExerciseDTO.getDuration());
        enduranceExercise.setEnduranceExerciseDetails(enduranceExerciseDTO.getEnduranceExerciseDetails());
    }

    private EnduranceExercise mapToEntity(EnduranceExerciseDTO enduranceExerciseDTO) {
        return mapper.mapToEntity(enduranceExerciseDTO);
    }

    private EnduranceExerciseDTO mapToDTO(EnduranceExercise enduranceExercise) {
        return mapper.mapToDTO(enduranceExercise);
    }

    private List<EnduranceExerciseDTO> mapToDTOs(List<EnduranceExercise> list) {
        return mapper.mapToDTOs(list);
    }
}
