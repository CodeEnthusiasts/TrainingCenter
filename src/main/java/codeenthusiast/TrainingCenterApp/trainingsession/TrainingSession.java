package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
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

    @OneToMany
    private List<StrengthExercise> strengthExercises;

    @OneToMany
    private List<EnduranceExercise> enduranceExercises;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime trainingDuration;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String notes;

}
