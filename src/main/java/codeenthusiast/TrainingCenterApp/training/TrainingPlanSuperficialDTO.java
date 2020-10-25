package codeenthusiast.TrainingCenterApp.training;

import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TrainingPlanSuperficialDTO {

    private LocalDate startDate;

    private LocalDate endDate;

    private Difficulty difficulty;

    private List<Priority> priorities;

}
