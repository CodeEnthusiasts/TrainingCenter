package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;


import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Entity(name = "endurance_exercises")
@Getter
@Setter
public class EnduranceExercise extends Exercise {

    @Enumerated(EnumType.STRING)
    private DistanceUnit distanceUnit;

    private double distance;

    @Enumerated(EnumType.STRING)
    private TimeUnit timeUnit;

    private LocalTime duration;

    @Embedded
    private EnduranceExerciseDetails enduranceExerciseDetails;

    @ManyToOne
    private TrainingSession trainingSession;


}
