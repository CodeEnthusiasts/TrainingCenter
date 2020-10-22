package codeenthusiast.TrainingCenterApp.training;

import codeenthusiast.TrainingCenterApp.user.User;

import javax.persistence.*;

@Entity
public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //todo create rest of entity

    @ManyToOne
    private User user;
}
