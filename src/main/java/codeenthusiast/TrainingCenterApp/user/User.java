package codeenthusiast.TrainingCenterApp.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private UserDetails userDetails;

    private UserGoals userGoals;

    private List<TrainingPlan> trainingPlans;

    private List<CustomExercise> customExercises;
}
