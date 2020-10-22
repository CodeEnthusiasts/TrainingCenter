package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthRecordDTO {

    @NotNull
    private String exerciseName;

    @NotNull
    private WeightUnit weightUnit;

    @NotNull
    @Range(min = -30, max = 500)
    private int weight;

    @NotNull
    private RepetitionUnit repetitionUnit;

    @NotNull
    @Range(min = 0, max = 1000)
    private int repetition;

    @NotNull
    private LocalDate setDate;

}
