package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "priorities")
@Getter
@Setter
@NoArgsConstructor
public class Priority extends AbstractEntity {

    private String name;

    private String details;

    @ManyToOne
    private TrainingPlan trainingPlan;
}
