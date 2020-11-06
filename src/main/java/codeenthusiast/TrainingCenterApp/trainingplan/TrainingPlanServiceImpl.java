package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseDetails;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement.KeyTechniqueElement;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace.Pace;
import codeenthusiast.TrainingCenterApp.mappers.TrainingPlanMapper;
import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

    private TrainingPlanRepository trainingPlanRepository;

    private TrainingPlanMapper trainingPlanMapper;

    public TrainingPlanServiceImpl(TrainingPlanRepository trainingPlanRepository, TrainingPlanMapper trainingPlanMapper) {
        this.trainingPlanRepository = trainingPlanRepository;
        this.trainingPlanMapper = trainingPlanMapper;
    }

    @Override
    public TrainingPlanSuperficialDTO findById(Long id) {
        TrainingPlan entity = trainingPlanRepository.getOne(id);
        return trainingPlanMapper.mapToSuperficialDTO(entity);
    }

    @Override
    public List<TrainingPlanSuperficialDTO> getAll() {
        return trainingPlanMapper.mapToSuperficialDTOs(trainingPlanRepository.findAll());
    }

    @Override
    public TrainingPlanDTO save(TrainingPlanDTO dto) {
        TrainingPlan entity = trainingPlanMapper.mapToEntity(dto);
        return trainingPlanMapper.mapToDTO(trainingPlanRepository.save(entity));
    }

    @Override
    @Transactional
    public TrainingPlanDTO update(Long id, TrainingPlanDTO dto) {
        dto.setId(id);
        TrainingPlan entity = trainingPlanMapper.mapToEntity(dto);
        return trainingPlanMapper.mapToDTO(trainingPlanRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        trainingPlanRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init(){
        // list ts
        List<TrainingSession> ts = new ArrayList<>();

        // movements
        Exercisable squat = new Movement("Squat");

        //pace
        Pace p1 = new Pace("Slow", 3 ,2, 1, 1);

        // list key tech elements
        List<KeyTechniqueElement> kte = new ArrayList<>();
        KeyTechniqueElement kte1 = new KeyTechniqueElement("ATG!");
        KeyTechniqueElement kte2 = new KeyTechniqueElement("Knees wide!");
        kte.add(kte1);
        kte.add(kte2);
        //details
        StrengthExerciseDetails details = new StrengthExerciseDetails(p1,
                3, kte);
        // Exercises list
        Exercise sq1 = new StrengthExercise(squat, 5, RepetitionUnit.MOTION, new int[]{4,5,6,7},
                WeightUnit.KILOGRAMS, new int[]{150, 140, 130, 120}, details);

        Exercise sq2 = new StrengthExercise(squat, 6, RepetitionUnit.MOTION, new int[]{3,3,3,3,3,3},
                WeightUnit.KILOGRAMS, new int[]{160, 160, 160, 160, 160, 160}, details);
        List<Exercise> sq = new ArrayList<>();
        sq.add(sq1);
        sq.add(sq2);
        // training sessions
        TrainingSession ts1 = new TrainingSession("Legs", sq, DayOfWeek.FRIDAY, LocalDate.now(),
                LocalTime.now(), LocalTime.now(), LocalTime.ofNanoOfDay(123123213L), Difficulty.MEDIUM, "DESC" );
        TrainingSession ts2 = new TrainingSession("Back", sq, DayOfWeek.SUNDAY, LocalDate.now(),
                LocalTime.now(), LocalTime.now(), LocalTime.ofNanoOfDay(1231232L), Difficulty.MEDIUM, "desc2" );
        List<TrainingSession> list = new ArrayList<>();
        list.add(ts1);
        list.add(ts2);
        // priorities
        Priority pr1 = new Priority("Chest", "Grow upper parts of chest");
        Priority pr2 = new Priority("Biceps", "desc");
        List<Priority> prs1 = new ArrayList<>();
        prs1.add(pr1);
        prs1.add(pr2);

        TrainingPlanDTO plan = new TrainingPlanDTO("Strength", null, 3, LocalDate.now().minusDays(20), LocalDate.now(),
                "Test description", Difficulty.MEDIUM, null);
        save(plan);
    }

}
