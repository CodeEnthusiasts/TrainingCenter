package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.mappers.TrainingPlanMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

@Service
public class TrainingPlanServiceImpl
        extends AbstractServiceImpl<TrainingPlan, TrainingPlanSuperficialDTO>
        implements TrainingPlanService {

    private TrainingPlanRepository trainingPlanRepository;

    private TrainingPlanMapper trainingPlanMapper;

    public TrainingPlanServiceImpl(AbstractRepository<TrainingPlan> repository, AbstractMapper<TrainingPlan,
            TrainingPlanSuperficialDTO> mapper, TrainingPlanRepository trainingPlanRepository, TrainingPlanMapper trainingPlanMapper) {
        super(repository, mapper);
        this.trainingPlanRepository = trainingPlanRepository;
        this.trainingPlanMapper = trainingPlanMapper;
    }



    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        TrainingPlanSuperficialDTO trainingPlanSuperficialDTO
                = new TrainingPlanSuperficialDTO("Strength", LocalDate.of(2020, Month.OCTOBER, 1),
                LocalDate.of(2020, Month.JANUARY, 1), 5, 8, Difficulty.MEDIUM,
                Collections.emptyList());
        save(trainingPlanSuperficialDTO);


    }

}
