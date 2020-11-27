package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExerciseDetailsDTO extends AbstractDTO {

    private String note;

    private short lowering;

    private short holdingDown;

    private short raising;

    private short holdingUp;

    private int repsInReserve;

}
