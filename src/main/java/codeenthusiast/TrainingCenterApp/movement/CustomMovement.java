package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.user.User;

import javax.persistence.*;

@Entity
public class CustomMovement implements Exercisable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //todo create rest of entity

    @ManyToOne
    private User user;
}
