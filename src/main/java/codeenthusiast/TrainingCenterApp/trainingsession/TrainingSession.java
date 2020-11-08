package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "training_sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingSession extends AbstractEntity {

    private String name;

    @ManyToMany
    private List<Exercise> exercises;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime trainingDuration;
    // endTime - startTime in service;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String notes;

}
