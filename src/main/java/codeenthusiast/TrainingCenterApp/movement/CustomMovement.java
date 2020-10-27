package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomMovement extends Motion {

    @ManyToOne
    private User user;

}
