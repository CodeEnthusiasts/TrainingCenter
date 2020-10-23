package codeenthusiast.TrainingCenterApp.exercise;

import codeenthusiast.TrainingCenterApp.movement.Exercisable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
public abstract class Exercise {

    private Exercisable exercise;

    int sets;
}
