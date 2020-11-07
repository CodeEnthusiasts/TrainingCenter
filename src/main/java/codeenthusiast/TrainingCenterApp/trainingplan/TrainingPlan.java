package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.user.major.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "training_plans")
@Getter
@Setter
@NoArgsConstructor
public class TrainingPlan extends AbstractEntity {

    private String name;

    @OneToMany
    private List<TrainingSession> trainingSessions;

    private int numberOfExecutedTrainings;

    private int numberOfPlannedTrainings;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany
    private List<Priority> priorities;


}
