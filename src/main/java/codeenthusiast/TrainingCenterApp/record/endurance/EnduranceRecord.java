package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnduranceRecord extends AbstractEntity {

    @Length(max = 50)
    private String movementName;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private DistanceUnit distanceUnit;

    private double distance;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private TimeUnit timeUnit;

    private LocalTime duration;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "personal_records_id")
    private PersonalRecords personalRecords;

}
