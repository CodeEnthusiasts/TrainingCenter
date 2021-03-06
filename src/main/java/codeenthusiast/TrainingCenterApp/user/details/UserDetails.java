package codeenthusiast.TrainingCenterApp.user.details;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.constants.BodyWeightUnit;
import codeenthusiast.TrainingCenterApp.constants.HeightUnit;
import codeenthusiast.TrainingCenterApp.constants.Sex;
import codeenthusiast.TrainingCenterApp.user.major.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private BodyWeightUnit bodyWeightUnit;

    private double weight;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private HeightUnit heightUnit;

    private double height;

    private short age;

    @Enumerated(EnumType.STRING)
    @Length(max = 32)
    private Sex sex;

    public UserDetails(BodyWeightUnit bodyWeightUnit, double weight, HeightUnit heightUnit, double height, short age, Sex sex) {
        this.bodyWeightUnit = bodyWeightUnit;
        this.weight = weight;
        this.heightUnit = heightUnit;
        this.height = height;
        this.age = age;
        this.sex = sex;
    }
}
