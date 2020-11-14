package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/strength_exercises")
public class StrengthExerciseController extends AbstractController<StrengthExercise, StrengthExerciseDTO> {

    private StrengthExerciseServiceImpl strengthExerciseService;

    public StrengthExerciseController(StrengthExerciseServiceImpl strengthExerciseService) {
        this.strengthExerciseService = strengthExerciseService;
    }


    @Override
    public AbstractService<StrengthExercise, StrengthExerciseDTO> getService() {
        return strengthExerciseService;
    }
}

