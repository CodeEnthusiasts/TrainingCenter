package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnduranceExerciseDTO extends AbstractDTO {

    private DistanceUnit distanceUnit;

    private double distance;

    private TimeUnit timeUnit;

    private Duration time;

    private EnduranceExerciseDetails enduranceExerciseDetails;
}
