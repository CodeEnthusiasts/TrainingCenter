package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import javax.persistence.*;
import java.util.List;

@Embeddable
public class StrengthExerciseDetails {

    @OneToOne
    private Pace pace;

    private int repsInReserve;

    @OneToMany
    private List<KeyTechniqueElement> keyTechniqueElements;
}
