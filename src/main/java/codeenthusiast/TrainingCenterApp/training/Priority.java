package codeenthusiast.TrainingCenterApp.training;

import javax.persistence.*;

@Entity(name = "priorities")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TrainingPlan trainingPlan;
}
