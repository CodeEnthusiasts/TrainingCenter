package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.units.DistanceUnit;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class EnduranceRecordDTO {

    @NotNull
    private String exerciseName;

    @NotNull
    private DistanceUnit distanceUnit;

    @NotNull
    @Range(min = 0, max = 10000)
    private int distance;

    @NotNull
    private TimeUnit timeUnit;

    @NotNull
    @Range(min = 0, max = 1000)
    private int time;

    private LocalDate setDate;

    public EnduranceRecordDTO() {
    }

    public EnduranceRecordDTO(String exerciseName, DistanceUnit distanceUnit, int distance,
                              TimeUnit timeUnit, int time, LocalDate setDate) {
        this.exerciseName = exerciseName;
        this.distanceUnit = distanceUnit;
        this.distance = distance;
        this.timeUnit = timeUnit;
        this.time = time;
        this.setDate = setDate;
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
