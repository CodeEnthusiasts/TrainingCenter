package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class TrainingSessionServiceImpl implements TrainingSessionService, SecurityService {

    private final TrainingSessionRepository repository;

    private final TrainingSessionMapper mapper;

    private final TrainingPlanServiceImpl trainingPlanService;

    public TrainingSessionServiceImpl(TrainingSessionRepository repository,
                                      TrainingSessionMapper mapper,
                                      TrainingPlanServiceImpl trainingPlanService) {
        this.repository = repository;
        this.mapper = mapper;
        this.trainingPlanService = trainingPlanService;
    }

    @Override
    public TrainingSession getTrainingSessionEntityById(Long trainingPlanId) {
        TrainingSession trainingSession = repository.findById(trainingPlanId)
                .orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(trainingSession));
        return trainingSession;
    }

    @Override
    public TrainingSessionDTO getTrainingSessionById(Long id) {
        return mapToDTO(getTrainingSessionEntityById(id));
    }

    @Override
    public List<TrainingSessionDTO> getAllTrainingSessionsByTrainingPlanId(Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        return mapToDTOs(trainingPlan.getTrainingSessions());
    }

    @Override
    @Transactional
    public TrainingSessionDTO createTrainingSession(TrainingSessionDTO dto, Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        TrainingSession trainingSession = new TrainingSession(dto);
        trainingSession.setTrainingPlan(trainingPlan);
        log.info("Create new training session for training plan of ID {}", trainingPlanId);
        return mapToDTO(save(trainingSession));
    }

    @Override
    @Transactional
    public TrainingSessionDTO updateTrainingSession(Long id, TrainingSessionDTO dto) {
        TrainingSession trainingSession = getTrainingSessionEntityById(id);
        updateData(trainingSession, dto);
        log.info("Update training session of ID {}", id);
        return mapToDTO(trainingSession);
    }

    @Override
    public String deleteTrainingSession(Long id) {
        repository.delete(getTrainingSessionEntityById(id));
        log.info("Update training session of ID {}", id);
        return "Training session deleted successfully. ";
    }

    private boolean hasAccess(TrainingSession trainingSession) {
        return trainingSession.getTrainingPlan().getUser().getId().equals(getPrincipalId());
    }

    private TrainingSession save(TrainingSession trainingSession) {
        return repository.save(trainingSession);
    }

    private void updateData(TrainingSession oldSession, TrainingSessionDTO dto) {
        oldSession.setDate(dto.getDate());
        oldSession.setDayOfWeek(dto.getDayOfWeek());
        oldSession.setDifficulty(dto.getDifficulty());
        oldSession.setEndTime(dto.getEndTime());
        oldSession.setStartTime(dto.getStartTime());
        oldSession.setName(dto.getName());
        oldSession.setNotes(dto.getNotes());
    }

    private TrainingSessionDTO mapToDTO(TrainingSession trainingSession) {
        return mapper.mapToDTO(trainingSession);
    }

    private List<TrainingSessionDTO> mapToDTOs(List<TrainingSession> list) {
        return mapper.mapToDTOs(list);
    }

    public TrainingSession getTest(Long id) {
        return repository.findById(id).get();
    }

    public short calculateTonnage(Long id) {
        TrainingSession trainingSession = getTrainingSessionEntityById(id);
        short tonnage = 0;

        for (StrengthExercise exercise : trainingSession.getStrengthExercises()) {

            if(exercise.getRepetitionUnit() == RepetitionUnit.TIME){
                continue;
            }
            if (exercise.getWeightUnit() == WeightUnit.BODYWEIGHT) {
                calculateForBodyWeight(exercise);
            }

            tonnage += exercise.getReps() * exercise.getWeight();
        }
        return tonnage;
    }

    public void calculateForBodyWeight(StrengthExercise strengthExercise) {
        if (strengthExercise.getWeightUnit() == WeightUnit.BODYWEIGHT) {
            double userWeight = strengthExercise.getTrainingSession().getTrainingPlan().getUser().getUserDetails().getWeight();
            if (userWeight == 0) {
                throw new IllegalArgumentException(" You must add your weight if you want to calculate tonnage from body weight exercises");
            } else {
                strengthExercise.setWeight(userWeight);
            }
        }
    }
}
