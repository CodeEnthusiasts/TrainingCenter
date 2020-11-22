package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnduranceExerciseDetails {

    private short heartRate;

    private short vO2maxPercentage;

}
