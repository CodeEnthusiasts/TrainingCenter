package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Entity
@Getter
@Setter

public class EnduranceExercise extends Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DistanceUnit distanceUnit;

    @ManyToOne
    private TrainingSession trainingSession;

    private int distance[];

    @Enumerated(EnumType.STRING)
    private TimeUnit timeUnit;

    private Duration time[];

    @Embedded
    private EnduranceExerciseDetails enduranceExerciseDetails;

    public EnduranceExercise(TrainingSession trainingSession, Exercisable exercise, int sets,
                             DistanceUnit distanceUnit, int[] distance, TimeUnit timeUnit, Duration[] time,
                             EnduranceExerciseDetails enduranceExerciseDetails) {
        super(trainingSession, exercise, sets);
        this.distanceUnit = distanceUnit;
        this.distance = distance;
        this.timeUnit = timeUnit;
        this.time = time;
        this.enduranceExerciseDetails = enduranceExerciseDetails;
    }
}
