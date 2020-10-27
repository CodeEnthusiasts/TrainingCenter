package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EnduranceRecord extends AbstractEntity {

    @NotNull
    private String exerciseName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DistanceUnit distanceUnit;
    @NotNull
    @Range(min = 0, max = 10000)
    private int distance;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TimeUnit timeUnit;
    @NotNull
    @Range(min = 0, max = 1000)
    private int time;

    private LocalDate setDate;

    public EnduranceRecord(EnduranceRecordDTO enduranceRecordDTO) {
        this.exerciseName = enduranceRecordDTO.getExerciseName();
        this.distanceUnit = enduranceRecordDTO.getDistanceUnit();
        this.distance = enduranceRecordDTO.getDistance();
        this.timeUnit = enduranceRecordDTO.getTimeUnit();
        this.time = enduranceRecordDTO.getTime();
        this.setDate = enduranceRecordDTO.getSetDate();
    }

    public EnduranceRecord(String exerciseName, DistanceUnit distanceUnit, int distance,
                           TimeUnit timeUnit, int time, LocalDate setDate) {
        this.exerciseName = exerciseName;
        this.distanceUnit = distanceUnit;
        this.distance = distance;
        this.timeUnit = timeUnit;
        this.time = time;
        this.setDate = setDate;
    }

}
