package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthExerciseDetails extends AbstractEntity {

    @Length(max = 100)
    private String note;

    private short lowering;

    private short holdingDown;

    private short raising;

    private short holdingUp;

    private short repetitionsInReserve;

    @OneToOne
    @JoinColumn(name = "strength_exercise_id")
    @JsonIgnore
    private StrengthExercise strengthExercise;

}
