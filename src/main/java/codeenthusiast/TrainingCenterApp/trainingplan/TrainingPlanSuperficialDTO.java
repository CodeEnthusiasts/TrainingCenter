package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.priority.PrioritySuperficialDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TrainingPlanSuperficialDTO {

    private LocalDate startDate;

    private LocalDate endDate;

    private Difficulty difficulty;

    private List<PrioritySuperficialDTO> priorities;

}
