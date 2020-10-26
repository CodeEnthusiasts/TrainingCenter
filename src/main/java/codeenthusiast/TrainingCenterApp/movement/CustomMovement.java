package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomMovement extends AbstractEntity implements Exercisable{


    private String name;

    @ManyToOne
    private User user;

    public CustomMovement(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
