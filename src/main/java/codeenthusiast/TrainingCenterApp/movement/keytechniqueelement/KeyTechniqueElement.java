package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeyTechniqueElement extends AbstractEntity {

    @Length(max = 100)
    private String content;

    @ManyToOne
    @JoinColumn(name = "movement_id")
    private Movement movement;

    public KeyTechniqueElement(KeyTechniqueElementDTO dto) {
        this.content = dto.getContent();
    }
}
