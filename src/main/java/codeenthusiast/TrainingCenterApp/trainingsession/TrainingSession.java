package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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

    @Length(max = 50)
    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "trainingSession")
    @JsonIgnore
    private List<StrengthExercise> strengthExercises;

    @OneToMany(orphanRemoval = true, mappedBy = "trainingSession")
    @JsonIgnore
    private List<EnduranceExercise> enduranceExercises;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private DayOfWeek dayOfWeek;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime trainingDuration;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private Difficulty difficulty;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    public TrainingSession(TrainingSessionDTO trainingSessionDTO) {
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
