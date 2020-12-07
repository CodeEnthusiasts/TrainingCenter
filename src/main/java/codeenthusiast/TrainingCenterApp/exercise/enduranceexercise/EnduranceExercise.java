package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;


import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnduranceExercise extends Exercise {

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private DistanceUnit distanceUnit;

    private double distance;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private TimeUnit timeUnit;

    private LocalTime duration;

    @Embedded
    private EnduranceExerciseDetails enduranceExerciseDetails;

    @ManyToOne
    @JoinColumn(name = "training_session_id")
    private TrainingSession trainingSession;

    public EnduranceExercise(EnduranceExerciseDTO dto) {
        this.distanceUnit = dto.getDistanceUnit();
        this.distance = dto.getDistance();
        this.enduranceExerciseDetails = dto.getEnduranceExerciseDetails();
        this.duration = dto.getDuration();
        this.timeUnit = dto.getTimeUnit();
    }
}
