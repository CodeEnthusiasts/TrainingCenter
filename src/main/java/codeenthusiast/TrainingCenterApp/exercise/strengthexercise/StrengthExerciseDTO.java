package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExerciseDTO extends AbstractDTO {

    private RepetitionUnit repetitionUnit;

    private int[] reps;

    private WeightUnit weightUnit;

    private int[] weights;

    private StrengthExerciseDetails strengthExerciseDetails;
}
