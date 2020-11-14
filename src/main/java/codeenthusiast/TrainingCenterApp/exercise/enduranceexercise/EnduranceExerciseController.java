package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/endurance_exercises")
public class EnduranceExerciseController extends AbstractController<EnduranceExercise, EnduranceExerciseDTO> {

    private EnduranceExerciseServiceImpl enduranceExerciseService;

    public EnduranceExerciseController(EnduranceExerciseServiceImpl enduranceExerciseService) {
        this.enduranceExerciseService = enduranceExerciseService;
    }

    @Override
    public AbstractService<EnduranceExercise, EnduranceExerciseDTO> getService() {
        return enduranceExerciseService;
    }
}
