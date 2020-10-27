package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
public abstract class Exercisable extends AbstractEntity {

    private String name;

}
