package codeenthusiast.TrainingCenterApp.user.details;

import codeenthusiast.TrainingCenterApp.constants.BodyWeightUnit;
import codeenthusiast.TrainingCenterApp.constants.HeightUnit;
import codeenthusiast.TrainingCenterApp.constants.Sex;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Enumerated(EnumType.STRING)
    private BodyWeightUnit bodyWeightUnit;

    private double weight;

    @Enumerated(EnumType.STRING)
    private HeightUnit heightUnit;

    private double height;

    private int age;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @OneToOne
    private PersonalRecords personalRecords;
}
