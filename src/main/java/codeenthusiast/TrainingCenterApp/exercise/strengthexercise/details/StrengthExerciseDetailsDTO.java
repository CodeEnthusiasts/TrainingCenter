package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExerciseDetailsDTO extends AbstractDTO {

    private String note;

    @Range(min = 0, max = 10)
    private short lowering;

    @Range(min = 0, max = 10)
    private short holdingDown;

    @Range(min = 0, max = 10)
    private short raising;

    @Range(min = 0, max = 10)
    private short holdingUp;

    @Range(min = 0, max = 10)
    private int repsInReserve;

}
