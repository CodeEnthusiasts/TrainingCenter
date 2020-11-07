package codeenthusiast.TrainingCenterApp.exercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import lombok.*;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Exercise  extends AbstractEntity {

    @OneToOne
    private Exercisable exercisable;

    int sets;
}
