package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EnduranceExerciseDTO extends AbstractDTO {

    private DistanceUnit distanceUnit;

    private int[] distance;

    private TimeUnit timeUnit;

    private Duration time[];

    private EnduranceExerciseDetails enduranceExerciseDetails;
}
