package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace.Pace;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExercise extends Exercise {


    @Enumerated(EnumType.STRING)
    private RepetitionUnit repetitionUnit;

    private short reps;

    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    private double weight;

    @Embedded
    private StrengthExerciseDetails strengthExerciseDetails;

    @ManyToOne
    private TrainingSession trainingSession;

    StrengthExercise(StrengthExerciseDTO dto){
        this.repetitionUnit = dto.getRepetitionUnit();
        this.reps = dto.getReps();
        this.strengthExerciseDetails = dto.getStrengthExerciseDetails();
        this.weight = dto.getWeight();
        this.weightUnit = dto.getWeightUnit();
    }
}
