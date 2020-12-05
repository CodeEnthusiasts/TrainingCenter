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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthRecord extends AbstractEntity {

    private String movementName;

    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    private double weight;

    @Enumerated(EnumType.STRING)
    private RepetitionUnit repetitionUnit;

    private short reps;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "personal_records_id")
    private PersonalRecords personalRecords;

}

