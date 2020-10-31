package codeenthusiast.TrainingCenterApp.user.details;

import codeenthusiast.TrainingCenterApp.constants.BodyWeightUnit;
import codeenthusiast.TrainingCenterApp.constants.HeightUnit;
import codeenthusiast.TrainingCenterApp.constants.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsDTO {

    private BodyWeightUnit bodyWeightUnit;

    private double weight;

    private HeightUnit heightUnit;

    private double height;

    private int age;

    private Sex sex;

}
