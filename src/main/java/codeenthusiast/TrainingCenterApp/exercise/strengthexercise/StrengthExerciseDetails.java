package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace.Pace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExerciseDetails {

    @OneToOne
    private Pace pace;

    private int repsInReserve;

}
