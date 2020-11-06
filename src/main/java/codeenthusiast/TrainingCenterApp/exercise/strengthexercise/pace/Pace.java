package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pace extends AbstractEntity {

    private String name;

    private int lowering;

    private int holdingDown;

    private int raising;

    private int holdingUp;
}
