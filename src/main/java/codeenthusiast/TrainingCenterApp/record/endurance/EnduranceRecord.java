package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Entity(name = "endurance_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnduranceRecord extends AbstractEntity {

    @NotNull
    private String exerciseName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DistanceUnit distanceUnit;
    @NotNull
    @Range(min = 0, max = 10000)
    private double distance;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TimeUnit timeUnit;

    @NotNull
    private LocalTime duration;

    private LocalDate date;

}
