package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExerciseDetailsDTO extends AbstractDTO {

    private String note;

    @Size(min = 0, max = 10)
    private short lowering;

    @Size(min = 0, max = 10)
    private short holdingDown;

    @Size(min = 0, max = 10)
    private short raising;

    @Size(min = 0, max = 10)
    private short holdingUp;

    @Size(min = 0, max = 10)
    private int repsInReserve;

}
