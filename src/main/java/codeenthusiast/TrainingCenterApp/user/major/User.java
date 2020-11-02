package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.movement.CustomMovement;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.user.details.UserDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractEntity {

    private String username;

    private String password;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    @Embedded
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user")
    private List<TrainingPlan> trainingPlans = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CustomMovement> customMovements = new ArrayList<>();

    public User(String username, String password, String email) {
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public User(String username, String password, String email, UserDetails userDetails) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userDetails = userDetails;
    }

    public void addTrainingPlan(TrainingPlan trainingPlan) {
        trainingPlans.add(trainingPlan);
    }

    public void addCustomMovement(CustomMovement customMovement) {
        customMovements.add(customMovement);
    }

    public void deleteCustomMovement(CustomMovement customMovement) {
        customMovements.remove(customMovement);
    }


}
