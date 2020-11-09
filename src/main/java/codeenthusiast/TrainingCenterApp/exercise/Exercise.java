package codeenthusiast.TrainingCenterApp.exercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Exercise extends AbstractEntity {

    @ManyToOne
    private TrainingSession trainingSession;

    @OneToOne
    private Exercisable exercisable;

    int sets;
}
