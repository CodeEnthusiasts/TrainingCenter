package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.movement.keytechniqueelement.KeyTechniqueElement;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movement extends Exercisable {

    @OneToMany(mappedBy = "movement")
    private List<Muscle> musclesInvolved;

    @OneToMany(mappedBy = "movement")
    private List<Image> images;

    @OneToMany
    private List<KeyTechniqueElement> keyTechniqueElements;

    public Movement(String name, List<Muscle> musclesInvolved) {
        super(name);
        this.musclesInvolved = musclesInvolved;
    }
}
