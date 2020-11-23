package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/strength_exercises")
public class StrengthExerciseController {

    private StrengthExerciseServiceImpl strengthExerciseService;

    //add
    //delete
    //update
    //get

}

