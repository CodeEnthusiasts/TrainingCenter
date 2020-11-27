package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
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

    @ManyToOne
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    public TrainingSession(TrainingSessionDTO trainingSessionDTO){
        this.date = trainingSessionDTO.getDate();
        this.dayOfWeek = trainingSessionDTO.getDayOfWeek();
        this.difficulty = trainingSessionDTO.getDifficulty();
        this.endTime = trainingSessionDTO.getEndTime();
        this.name = trainingSessionDTO.getName();
        this.startTime = trainingSessionDTO.getStartTime();
        this.trainingDuration = trainingSessionDTO.getTrainingDuration();
        this.notes = trainingSessionDTO.getNotes();
    }

}
