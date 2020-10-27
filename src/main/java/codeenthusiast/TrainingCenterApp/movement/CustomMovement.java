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
public class CustomMovement extends Exercisable{

    @ManyToOne
    private User user;

    public CustomMovement(String name) {
        super(name);
    }
}
