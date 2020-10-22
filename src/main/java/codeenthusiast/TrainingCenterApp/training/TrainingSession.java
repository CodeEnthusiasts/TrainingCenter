package codeenthusiast.TrainingCenterApp.training;

import javax.persistence.*;

@Entity(name = "training_sessions")
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TrainingPlan trainingPlan;
}
