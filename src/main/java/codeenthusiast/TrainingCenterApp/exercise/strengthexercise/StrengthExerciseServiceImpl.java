package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

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

    public StrengthExercise getStrengthExerciseById(long id) {
        return strengthExerciseRepository.findById(id);
    }

    @Override
    public StrengthExerciseDTO findById(Long id) {
        StrengthExercise strengthExercise = strengthExerciseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        if(!hasAccess(strengthExercise)){
            throw new AccessDeniedException("Access denied");
        }
        return strengthExerciseMapper.mapToDTO(strengthExercise);
    }

    private StrengthExercise findByEntityId(Long id) {
        StrengthExercise strengthExercise = strengthExerciseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        if(!hasAccess(strengthExercise)){
            throw new AccessDeniedException("Access denied");
        }
        return strengthExercise;
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
    public List<StrengthExerciseDTO> getAllByTrainingSessionId(Long trainingSessionId) {
        TrainingSession trainingSession = trainingSessionService.findEntityById(trainingSessionId);
        if(trainingSessionService.hasAccess(trainingSession)){
            throw new AccessDeniedException("Access denied");
        }
        return strengthExerciseMapper.mapToDTOs(trainingSession.getStrengthExercises());
    }

    @Override
    public StrengthExerciseDTO update(Long id, StrengthExerciseDTO dto) {
        StrengthExercise oldExercise = findByEntityId(id);
        if(!hasAccess(oldExercise)){
            throw new AccessDeniedException("Access denied");
        }
        oldExercise.setRepetitionUnit(dto.getRepetitionUnit());
        oldExercise.setReps(dto.getReps());
        oldExercise.setStrengthExerciseDetails(dto.getStrengthExerciseDetails());
        oldExercise.setWeight(dto.getWeight());
        oldExercise.setWeightUnit(dto.getWeightUnit());
        return save(strengthExerciseMapper.mapToDTO(oldExercise));
    }




    @Override
    public StrengthExerciseDTO create(StrengthExerciseDTO dto, Long trainingSessionId, Long movementId) {
        TrainingSession trainingSession = trainingSessionService.findEntityById(trainingSessionId);
        if(trainingSessionService.hasAccess(trainingSession)){
            throw new AccessDeniedException("Access denied");
        }
        StrengthExercise strengthExercise = new StrengthExercise(dto);
        save(strengthExercise, trainingSessionId, movementId);
        return strengthExerciseMapper.mapToDTO(strengthExercise);
    }


    @Override
    public void deleteById(Long id) {
        findById(id);
        strengthExerciseRepository.deleteById(id);
    }

    private boolean hasAccess(StrengthExercise strengthExercise) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return strengthExercise.getTrainingSession().getTrainingPlan().getUser().getId().equals(userDetailsImpl.getId());
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }
}
