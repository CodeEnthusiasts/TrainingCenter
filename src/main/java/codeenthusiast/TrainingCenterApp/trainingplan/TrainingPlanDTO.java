package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TrainingPlanDTO extends AbstractDTO {

    private String name;
    //change there
    private List<TrainingSession> changeThere;

    private int numberOfPlannedTrainings;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private Difficulty difficulty;
    //change there
    private List<Priority> priorities;
}
