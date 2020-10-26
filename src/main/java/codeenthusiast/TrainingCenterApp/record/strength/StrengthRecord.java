package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StrengthRecord extends AbstractEntity {
    @NotNull
    private String exerciseName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;
    @NotNull
    @Range(min = -30, max = 500)
    private int weight;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RepetitionUnit repetitionUnit;
    @NotNull
    @Range(min = 0, max = 1000)
    private int repetition;

    private LocalDate setDate;


    public StrengthRecord(StrengthRecordDTO strengthRecordDTO) {
        this.exerciseName = strengthRecordDTO.getExerciseName();
        this.weightUnit = strengthRecordDTO.getWeightUnit();
        this.weight = strengthRecordDTO.getWeight();
        this.repetitionUnit = strengthRecordDTO.getRepetitionUnit();
        this.repetition = strengthRecordDTO.getRepetition();
        this.setDate = strengthRecordDTO.getSetDate();
    }

    public StrengthRecord(String exerciseName, WeightUnit weightUnit, int weight,
                          RepetitionUnit repetitionUnit, int repetition, LocalDate setDate) {
        this.exerciseName = exerciseName;
        this.weightUnit = weightUnit;
        this.weight = weight;
        this.repetitionUnit = repetitionUnit;
        this.repetition = repetition;
        this.setDate = setDate;
    }

}

