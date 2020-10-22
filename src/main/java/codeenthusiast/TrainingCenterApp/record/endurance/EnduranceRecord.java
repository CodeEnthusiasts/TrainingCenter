package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.units.DistanceUnit;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@Entity
public class EnduranceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // todo create whole class

    private String exerciseName;

    @Enumerated(EnumType.STRING)
    private DistanceUnit distanceUnit;

    private int distance;

    @Enumerated(EnumType.STRING)
    private TimeUnit timeUnit;

    private int time;

    private LocalDate setDate;

    public EnduranceRecord() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public DistanceUnit getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(DistanceUnit distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public LocalDate getSetDate() {
        return setDate;
    }

    public void setSetDate(LocalDate setDate) {
        this.setDate = setDate;
    }
}
