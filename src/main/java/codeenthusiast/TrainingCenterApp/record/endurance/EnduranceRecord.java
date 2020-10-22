package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.units.DistanceUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EnduranceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exerciseName;

    @Enumerated(EnumType.STRING)
    private DistanceUnit distanceUnit;

    private int distance;

    @Enumerated(EnumType.STRING)
    private TimeUnit timeUnit;

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
