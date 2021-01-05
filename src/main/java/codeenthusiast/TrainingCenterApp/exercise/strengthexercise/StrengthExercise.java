package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details.StrengthExerciseDetails;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExercise extends Exercise {


    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private RepetitionUnit repetitionUnit;

    private short reps;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private WeightUnit weightUnit;

    private Double weight;

    @OneToOne(orphanRemoval = true, mappedBy = "strengthExercise")
    @JsonIgnore
    private StrengthExerciseDetails strengthExerciseDetails;

    @ManyToOne
    @JoinColumn(name = "training_session_id")
    private TrainingSession trainingSession;

    StrengthExercise(StrengthExerciseDTO dto){
        this.repetitionUnit = dto.getRepetitionUnit();
        this.reps = dto.getReps();
        this.weight = dto.getWeight();
        this.weightUnit = dto.getWeightUnit();
    }
}
