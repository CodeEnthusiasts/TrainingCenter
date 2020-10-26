package codeenthusiast.TrainingCenterApp.exercise;

import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
public abstract class Exercise {

    @ManyToOne
    private TrainingSession trainingSession;

    private Exercisable exercisable;

    int sets;
}
