package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StrengthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exerciseName;

    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    private int weight;

    @Enumerated(EnumType.STRING)
    private RepetitionUnit repetitionUnit;

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

