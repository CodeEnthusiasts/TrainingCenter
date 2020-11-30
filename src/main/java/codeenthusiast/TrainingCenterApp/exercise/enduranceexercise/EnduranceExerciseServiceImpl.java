package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementServiceImpl;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionServiceImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnduranceExerciseServiceImpl implements EnduranceExerciseService {

    private final EnduranceExerciseRepository repository;

    private final TrainingSessionServiceImpl trainingSessionService;

    private final MovementServiceImpl movementService;

    private final EnduranceExerciseMapper mapper;

    public EnduranceExerciseServiceImpl(EnduranceExerciseRepository repository,
                                        TrainingSessionServiceImpl trainingSessionService,
                                        MovementServiceImpl movementService,
                                        EnduranceExerciseMapper mapper) {
        this.repository = repository;
        this.trainingSessionService = trainingSessionService;
        this.movementService = movementService;
        this.mapper = mapper;
    }

    @Override
    public EnduranceExercise getEnduranceExerciseEntityById(Long id) {
        return null;
    }

    @Override
    public EnduranceExerciseDTO createEnduranceExercise(EnduranceExerciseDTO dto, Long trainingSessionId, Long movementId) {
        TrainingSession trainingSession = trainingSessionService.findEntityById(trainingSessionId);
        if(!trainingSessionService.hasAccess(trainingSession))
            throw new AccessDeniedException("Access denied");
        Movement movement = movementService.findEntityById(movementId);
        EnduranceExercise enduranceExercise = mapToEntity(dto);
        enduranceExercise.setMovement(movement);
        enduranceExercise.setTrainingSession(trainingSession);
        return mapToDTO(save(enduranceExercise));
    }

    @Override
    public EnduranceExerciseDTO updateEnduranceExercise(Long enduranceExerciseId,
                                                        EnduranceExerciseDTO dto) {
        EnduranceExercise enduranceExercise = getEnduranceExerciseByIdFromRepo(enduranceExerciseId);
        if(isNull(enduranceExercise))
            throw new EntityNotFoundException("Resource not available");
        if(!hasAccess(enduranceExercise))
            throw new AccessDeniedException("Access denied");
        updateEnduranceExercise(enduranceExercise, dto);
        return mapToDTO(save(enduranceExercise));
    }

    @Override
    public EnduranceExerciseDTO getEnduranceExerciseById(Long enduranceExerciseId) {
        EnduranceExercise enduranceExercise = getEnduranceExerciseByIdFromRepo(enduranceExerciseId);
        if(isNull(enduranceExercise))
            throw new EntityNotFoundException("Resource not available");
        if(!hasAccess(enduranceExercise))
            throw new AccessDeniedException("Access denied");
        return mapToDTO(enduranceExercise);
    }

    @Override
    public List<EnduranceExerciseDTO> getAllEnduranceExercisesByTrainingSessionId(
            Long trainingSessionId) {

        TrainingSession trainingSession = trainingSessionService.findEntityById(trainingSessionId);
        if(!trainingSessionService.hasAccess(trainingSession))
            throw new AccessDeniedException("Access denied");
        return mapToDTOs(repository.findAllByTrainingSessionId(trainingSessionId));
    }

    @Override
    public String deleteEnduranceExercise(Long enduranceExerciseId) {
        EnduranceExercise enduranceExercise = getEnduranceExerciseByIdFromRepo(enduranceExerciseId);
        if(isNull(enduranceExercise))
            throw new EntityNotFoundException("Resource not available");
        if(!hasAccess(enduranceExercise))
            throw new AccessDeniedException("Access denied");
        deleteById(enduranceExerciseId);
        return "Exercise deleted successfully. ";
    }

    private boolean hasAccess(EnduranceExercise enduranceExercise) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return enduranceExercise.getTrainingSession()
                                .getTrainingPlan()
                                .getUser()
                                .getId()
                                .equals(userDetailsImpl.getId());
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }

    private boolean isNull(EnduranceExercise enduranceExercise) {
        return enduranceExercise == null;
    }

    private EnduranceExercise save(EnduranceExercise enduranceExercise) {
        return repository.save(enduranceExercise);
    }

    private EnduranceExercise getEnduranceExerciseByIdFromRepo(long id) {
        return repository.findById(id);
    }

    private void updateEnduranceExercise(EnduranceExercise enduranceExercise,
                                         EnduranceExerciseDTO enduranceExerciseDTO) {
        enduranceExercise.setDistanceUnit(enduranceExerciseDTO.getDistanceUnit());
        enduranceExercise.setDistance(enduranceExerciseDTO.getDistance());
        enduranceExercise.setTimeUnit(enduranceExerciseDTO.getTimeUnit());
        enduranceExercise.setDuration(enduranceExerciseDTO.getDuration());
        enduranceExercise.setEnduranceExerciseDetails(enduranceExerciseDTO.getEnduranceExerciseDetails());
    }

    private void deleteById(Long id) {
        repository.deleteById(id);
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
