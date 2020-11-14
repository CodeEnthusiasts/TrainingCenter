package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.image.Image;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Muscle extends AbstractEntity {

    private String name;

    private String description;

    @OneToMany
    private List<Image> images;

    public Muscle(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Muscle(MuscleDTO muscleDTO) {
        this.name = muscleDTO.getName();
        this.description = muscleDTO.getDescription();
    }

}
