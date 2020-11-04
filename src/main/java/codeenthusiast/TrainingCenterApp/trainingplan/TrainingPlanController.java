package codeenthusiast.TrainingCenterApp.trainingplan;


import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.priority.PrioritySuperficialDTO;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/training_plans")
public class TrainingPlanController extends AbstractController<TrainingPlan, TrainingPlanSuperficialDTO> {

    private TrainingPlanService trainingPlanService;

    public TrainingPlanController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @Override
    public AbstractService<TrainingPlan, TrainingPlanSuperficialDTO> getService() {
        return trainingPlanService;
    }

}
