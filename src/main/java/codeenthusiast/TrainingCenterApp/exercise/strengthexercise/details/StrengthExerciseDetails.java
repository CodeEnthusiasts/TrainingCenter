package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExerciseDetails extends AbstractEntity {

    private String note;

    private short lowering;

    private short holdingDown;

    private short raising;

    private short holdingUp;

    private int repsInReserve;

    @OneToOne
    @JoinColumn(name = "strength_exercise_id")
    private StrengthExercise strengthExercise;

}
