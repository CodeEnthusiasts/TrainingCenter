package codeenthusiast.TrainingCenterApp.training;

import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

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

//    @OneToMany
//    private List<?extends Exercise> exercises;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime trainingDuration;
    // endTime - startTime in service;

    private String notes ;

    @ManyToOne
    @JsonIgnore
    private TrainingPlan trainingPlan;
}
