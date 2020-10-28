package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeyTechniqueElement extends AbstractEntity {

    private String content;
}
