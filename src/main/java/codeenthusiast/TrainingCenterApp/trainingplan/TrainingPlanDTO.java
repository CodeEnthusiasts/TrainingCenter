package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.priority.PriorityDTO;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingPlanDTO extends AbstractDTO {

    @NotNull
    private String name;


    private short numberOfPlannedTrainings;

    private short numberOfExecutedTrainings;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private Difficulty difficulty;

    @JsonIgnore
    private List<PriorityDTO> priorities;

    @JsonIgnore
    private List<TrainingSessionDTO> trainingSessions;

}
