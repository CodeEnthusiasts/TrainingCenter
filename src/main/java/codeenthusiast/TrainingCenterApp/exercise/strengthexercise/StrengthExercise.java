package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "strength_exercises")
@Getter
@Setter
public class StrengthExercise extends Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RepetitionUnit repetitionUnit;

    @ManyToOne
    private TrainingSession trainingSession;

    private int[] reps;

    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    private int[] weights;

    @Embedded
    private StrengthExerciseDetails strengthExerciseDetails;

    public StrengthExercise(TrainingSession trainingSession, Exercisable exercise, int sets,
                            RepetitionUnit repetitionUnit, int[] reps, WeightUnit weightUnit,
                            int[] weights, StrengthExerciseDetails strengthExerciseDetails) {
        super(trainingSession, exercise, sets);
        this.repetitionUnit = repetitionUnit;
        this.reps = reps;
        this.weightUnit = weightUnit;
        this.weights = weights;
        this.strengthExerciseDetails = strengthExerciseDetails;
    }
}
