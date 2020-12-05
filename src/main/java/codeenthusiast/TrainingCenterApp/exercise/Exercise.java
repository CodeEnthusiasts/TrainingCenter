package codeenthusiast.TrainingCenterApp.exercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Exercise extends AbstractEntity {

    @ManyToOne
    private TrainingSession trainingSession;

    @OneToOne
    private Movement movement;

}
