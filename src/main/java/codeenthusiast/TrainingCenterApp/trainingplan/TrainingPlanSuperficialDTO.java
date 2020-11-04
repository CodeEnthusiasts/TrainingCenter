package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.priority.PrioritySuperficialDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingPlanSuperficialDTO extends AbstractDTO {

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private int numberOfExecutedTrainings;

    private int numberOfPlannedTrainings;

    private Difficulty difficulty;

    private List<PrioritySuperficialDTO> priorities;

    public TrainingPlanSuperficialDTO(String name, LocalDate startDate, LocalDate endDate,
                                      Difficulty difficulty) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.difficulty = difficulty;
    }
}
