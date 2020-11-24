package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pace extends AbstractEntity {

    private String name;

    private short lowering;

    private short holdingDown;

    private short raising;

    private short holdingUp;

    @OneToOne
    @JoinColumn(name = "strength_exercise_id")
    private StrengthExercise strengthExercise;
}
