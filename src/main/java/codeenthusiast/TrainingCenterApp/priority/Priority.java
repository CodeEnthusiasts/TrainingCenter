package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Priority extends AbstractEntity {

    @Length(max = 100)
    private String name;

    @Length(max = 500)
    private String details;

    @ManyToOne
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    Priority(PriorityDTO dto){
        this.name = dto.getName();
        this.details = dto.getDetails();
    }

}
