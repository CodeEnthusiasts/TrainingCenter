package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private int reps;

    private LocalDate date;

    @ManyToOne
    private PersonalRecords personalRecords;

}

