package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.movement.keytechniqueelement.KeyTechniqueElement;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movement extends AbstractEntity {

    private String name;

    @OneToMany(mappedBy = "movement")
    @JsonIgnore
    private List<Muscle> musclesInvolved;

    @OneToMany(mappedBy = "movement")
    @JsonIgnore
    private List<Image> images;

    @OneToMany(mappedBy = "movement")
    private List<KeyTechniqueElement> keyTechniqueElements;

    public Movement(String name, List<Muscle> musclesInvolved) {
        this.musclesInvolved = musclesInvolved;
    }

    public Movement(MovementDTO movementDTO){
        this.name = movementDTO.getName();
    }
}
