package codeenthusiast.TrainingCenterApp.training;

import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private TrainingPlan trainingPlan;

//    @OneToMany
//    private List<? extends Exercise> exercises;

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

    public TrainingSession(String name, TrainingPlan trainingPlan,
                           DayOfWeek dayOfWeek, LocalDate date, Difficulty difficulty) {
        this.name = name;
//        this.exercises = exercises;
        this.trainingPlan = trainingPlan;
        this.dayOfWeek = dayOfWeek;
        this.date = date;
        this.difficulty = difficulty;
    }
}
