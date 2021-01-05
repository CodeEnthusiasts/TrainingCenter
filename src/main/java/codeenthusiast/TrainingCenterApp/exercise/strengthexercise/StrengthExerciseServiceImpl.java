package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementServiceImpl;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
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
    @Transactional
    public StrengthExerciseDTO save(StrengthExercise strengthExercise, Long trainingSessionId, Long movementId) {

        TrainingSession trainingSession = trainingSessionService.getTrainingSessionEntityById(trainingSessionId);
        Movement movement = movementService.findEntityById(movementId);

        strengthExercise.setMovement(movement);
        strengthExercise.setTrainingSession(trainingSession);

        StrengthExercise result = strengthExerciseRepository.save(strengthExercise);
        log.info("New exercises was added");
        return strengthExerciseMapper.mapToDTO(result);
    }


    private StrengthExerciseDTO save(StrengthExercise oldExercise) {
        StrengthExercise strengthExercise = strengthExerciseRepository.save(oldExercise);
        return strengthExerciseMapper.mapToDTO(strengthExercise);
    }

    @Override
    public List<StrengthExerciseDTO> getAllByTrainingSessionId(Long trainingSessionId) {
        TrainingSession trainingSession = trainingSessionService.getTrainingSessionEntityById(trainingSessionId);
        List<StrengthExercise> strengthExercises = strengthExerciseRepository.findAllByTrainingSessionId(trainingSessionId);
        return strengthExerciseMapper.mapToDTOs(strengthExercises);
    }

    @Override
    @Transactional
    public StrengthExerciseDTO update(Long id, StrengthExerciseDTO dto) {
        StrengthExercise oldExercise = findEntityById(id);
        updateData(dto, oldExercise);

        log.info("Exercises was updated");
        return strengthExerciseMapper.mapToDTO(oldExercise);
    }

    private void updateData(StrengthExerciseDTO dto, StrengthExercise oldExercise) {
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
        log.info("Exercise was deleted");
        strengthExerciseRepository.deleteById(id);
    }

    private boolean hasAccess(StrengthExercise strengthExercise) {
        return strengthExercise.getTrainingSession().getTrainingPlan().getUser().getId().equals(getPrincipalId());
    }


    public short calculateTonnage(Long id) {
        StrengthExercise strengthExercise = findEntityById(id);

        validateTonnageData(strengthExercise);

        calculateForBodyWeight(strengthExercise);

        return (short) (strengthExercise.getReps() * strengthExercise.getWeight());
    }

    public void validateTonnageData(StrengthExercise strengthExercise) {
        if(strengthExercise.getWeight() == 0){
            throw new IllegalArgumentException(" Weight cannot equals to 0");
        }
        if(strengthExercise.getReps() == 0){
            throw new IllegalArgumentException(" Number of reps cannot equals to 0");
        }
    }

    public void calculateForBodyWeight(StrengthExercise strengthExercise) {
        if(strengthExercise.getWeightUnit() == WeightUnit.BODYWEIGHT){
            double userWeight = strengthExercise.getTrainingSession().getTrainingPlan().getUser().getUserDetails().getWeight();
            if(userWeight == 0){
                throw new IllegalArgumentException(" You must add your weight if you want to calculate tonnage from body weight exercises");
            } else {
                strengthExercise.setWeight(userWeight);
            }
        }
    }


}
