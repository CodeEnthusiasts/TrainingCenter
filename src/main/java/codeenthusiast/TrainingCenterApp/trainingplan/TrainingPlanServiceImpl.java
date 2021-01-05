package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.user.major.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Transient;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TrainingPlanServiceImpl implements TrainingPlanService, SecurityService {

    private final TrainingPlanRepository repository;

    private final TrainingPlanMapper mapper;

    private final UserServiceImpl userService;

    public TrainingPlanServiceImpl(TrainingPlanRepository repository, TrainingPlanMapper mapper, UserServiceImpl userService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public TrainingPlan getTrainingPlanEntityById(Long id) {
        TrainingPlan trainingPlan = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(trainingPlan));
        return trainingPlan;
    }

    @Override
    public TrainingPlanDTO getTrainingPlanById(Long id) {
        return mapToDTO(getTrainingPlanEntityById(id));
    }

    @Override
    @Transactional
    public TrainingPlanDTO createTrainingPlan(Long userId, TrainingPlanDTO trainingPlanDTO) {
        TrainingPlan trainingPlan = mapper.mapToEntity(trainingPlanDTO);
        trainingPlan.setUser(userService.findEntityById(userId));
        log.info("New training plan for user of ID {} was created", userId);
        return mapToDTO(save(trainingPlan));
    }

    @Override
    @Transactional
    public TrainingPlanDTO updateTrainingPlan(Long trainingPlanId, TrainingPlanDTO trainingPlanDTO) {
        TrainingPlan trainingPlan = getTrainingPlanEntityById(trainingPlanId);
        updateTrainingPlan(trainingPlan, trainingPlanDTO);
        log.info("Training plan of ID {} was updated", id);
        return mapToDTO(trainingPlan);
    }

    @Override
    public List<TrainingPlanDTO> getAllTrainingPlansByUserId(Long userId) {
        return mapToDTOs(repository.findAllByUserId(userId));
    }

    @Transient
    @Override
    public String deleteTrainingPlan(Long id) {
        repository.delete(getTrainingPlanEntityById(id));
        log.info("Training plan of ID {} was deleted", id);
        return "Training plan deleted successfully. ";
    }

    private boolean hasAccess(TrainingPlan trainingPLan) {
        return trainingPLan.getUser().getId().equals(getPrincipalId());
    }

    private TrainingPlan save(TrainingPlan trainingPlan) {
        return repository.save(trainingPlan);
    }

    private void updateTrainingPlan(TrainingPlan trainingPlan, TrainingPlanDTO trainingPlanDTO) {
        trainingPlan.setName(trainingPlanDTO.getName());
        trainingPlan.setStartDate(trainingPlanDTO.getStartDate());
        trainingPlan.setEndDate(trainingPlanDTO.getEndDate());
        trainingPlan.setDescription(trainingPlanDTO.getDescription());
        trainingPlan.setDifficulty(trainingPlanDTO.getDifficulty());
        trainingPlan.setNumberOfPlannedTrainings(trainingPlanDTO.getNumberOfPlannedTrainings());
        trainingPlan.setNumberOfExecutedTrainings(trainingPlanDTO.getNumberOfExecutedTrainings());
    }

    private List<TrainingPlanDTO> mapToDTOs(List<TrainingPlan> list) {
        return mapper.mapToDTOs(list);
    }

    private TrainingPlanDTO mapToDTO(TrainingPlan trainingPlan) {
        return mapper.mapToDTO(trainingPlan);
    }

    public short calculateTonnage(Long id) {
        TrainingPlan trainingPlan = getTrainingPlanEntityById(id);

        List<StrengthExercise> exercises = findStrengthExercisesInTrainingPlan(trainingPlan);

        short sum = 0;
        double userWeight = 0;
        for(StrengthExercise exercise : exercises){

            userWeight = checkBodyWeightUnit(userWeight, exercise);

            sum += calculateVolumeForSingleExercise(exercise);
        }
        return sum;
    }

    public List<StrengthExercise> findStrengthExercisesInTrainingPlan(TrainingPlan trainingPlan) {
        return trainingPlan.getTrainingSessions().stream()
                .flatMap(trainingSession -> trainingSession.getStrengthExercises().stream())
                .collect(Collectors.toList());
    }

    public short calculateVolumeForSingleExercise(StrengthExercise exercise) {
        short value = 0;
        if(!exercise.getRepetitionUnit().equals(RepetitionUnit.TIME)){
             value = (short) (exercise.getReps() * exercise.getWeight());
        }
        return value;
    }

    public double checkBodyWeightUnit(double userWeight, StrengthExercise exercise) {
        if(exercise.getWeightUnit().equals(WeightUnit.BODYWEIGHT)){
            if(userWeight != 0){
                exercise.setWeight(userWeight + exercise.getWeight());
            } else {
                userWeight = calculateAndSetWeightFromUserData(exercise);
            }
        }
        return userWeight;
    }

    public double calculateAndSetWeightFromUserData(StrengthExercise exercise) {
        double userWeight;
        double weight = exercise.getTrainingSession().getTrainingPlan().getUser().getUserDetails().getWeight();
        if(weight == 0){
            throw new IllegalArgumentException("Set user weight first before using BodyWeight load");
        }
        userWeight = weight;
        exercise.setWeight(userWeight + exercise.getWeight());
        return userWeight;
    }
}
