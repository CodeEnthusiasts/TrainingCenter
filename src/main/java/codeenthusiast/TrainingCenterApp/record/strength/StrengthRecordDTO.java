package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthRecordDTO extends AbstractDTO {

    @NotNull
    private String movementName;

    @NotNull
    private WeightUnit weightUnit;

    @NotNull
    private double weight;

    @NotNull
    private RepetitionUnit repetitionUnit;

    @NotNull
    private short repetition;

    private LocalDate setDate;

}
