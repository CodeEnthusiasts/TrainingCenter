package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExercise;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExerciseDTO;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingSessionDTO extends AbstractDTO {

    private String name;

    private DayOfWeek dayOfWeek;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime trainingDuration;

    private Difficulty difficulty;

    private String notes;

    @JsonIgnore
    private List<StrengthExerciseDTO> strengthExercises;

    @JsonIgnore
    private List<EnduranceExerciseDTO> enduranceExercises;
}
