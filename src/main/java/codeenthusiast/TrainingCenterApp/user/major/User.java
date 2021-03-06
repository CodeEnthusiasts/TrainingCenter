package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.user.details.UserDetails;
import codeenthusiast.TrainingCenterApp.user.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractEntity {

    @Length(max = 50)
    private String username;

    @Length(max = 84)
    private String password;

    @Length(max = 100)
    private String email;

    @ManyToMany
    private List<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Image image;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private UserDetails userDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<TrainingPlan> trainingPlans = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private PersonalRecords personalRecords;


    public User(String username, String password, String email) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.userDetails = new UserDetails();
        this.personalRecords = new PersonalRecords();
    }

    public User(String username, String password, String email, UserDetails userDetails) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userDetails = userDetails;
    }
}
