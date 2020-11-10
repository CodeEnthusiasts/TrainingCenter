package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "key_technique_elements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeyTechniqueElement extends AbstractEntity {

    private String content;

    @ManyToOne
    private Movement movement;
}
