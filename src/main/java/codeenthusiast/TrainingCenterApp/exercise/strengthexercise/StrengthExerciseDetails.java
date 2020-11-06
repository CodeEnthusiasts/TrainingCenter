package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement.KeyTechniqueElement;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace.Pace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class StrengthExerciseDetails {

    @OneToOne
    private Pace pace;

    private int repsInReserve;

    @OneToMany
    private List<KeyTechniqueElement> keyTechniqueElements;
}
