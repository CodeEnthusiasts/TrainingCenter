package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
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

    @ManyToMany
    private List<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Image image;

    @OneToOne(mappedBy = "user")
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user")
    private List<TrainingPlan> trainingPlans = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private PersonalRecords personalRecords;


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
}
