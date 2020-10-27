package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Movement extends Exercisable {

    @OneToMany
    private List<Muscle> musclesInvolved;

    @OneToMany
    private List<Image> images;

    public Movement(String name) {
        super(name);
    }
}
