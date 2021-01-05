package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.Difficulty;
import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.user.major.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingPlan extends AbstractEntity {

    @Length(max = 50)
    private String name;

    @OneToMany(mappedBy = "trainingPlan", orphanRemoval = true)
    @JsonIgnore
    private List<TrainingSession> trainingSessions;

    private short numberOfExecutedTrainings;

    private short numberOfPlannedTrainings;

    private LocalDate startDate;

    private LocalDate endDate;

    @Length(max = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private Difficulty difficulty;

    @OneToMany(mappedBy = "trainingPlan")
    @JsonIgnore
    private List<Priority> priorities;


}
