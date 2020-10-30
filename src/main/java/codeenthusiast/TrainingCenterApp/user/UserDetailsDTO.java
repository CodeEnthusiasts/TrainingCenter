package codeenthusiast.TrainingCenterApp.user;

import codeenthusiast.TrainingCenterApp.constants.BodyWeightUnit;
import codeenthusiast.TrainingCenterApp.constants.HeightUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDTO {

    private BodyWeightUnit bodyWeightUnit;

    private double weight;

    private HeightUnit heightUnit;

    private double height;

    private int age;

    private Sex sex;

}
