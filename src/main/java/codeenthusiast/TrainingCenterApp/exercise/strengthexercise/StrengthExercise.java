package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "strength_exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExercise extends Exercise{


    @Enumerated(EnumType.STRING)
    private RepetitionUnit repetitionUnit;

    private int reps;

    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    private int weight;

    @Embedded
    private StrengthExerciseDetails strengthExerciseDetails;

    @ManyToOne
    private TrainingSession trainingSession;



}
