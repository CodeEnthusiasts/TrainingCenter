package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movement implements Exercisable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Muscle> musclesInvolved;

    @OneToMany
    private List<Image> images;

    private void addInvolvedMuscle(Muscle muscle){
        musclesInvolved.add(muscle);
    }

    private void deleteInvolvedMuscle(Muscle muscle){
        musclesInvolved.add(muscle);
    }

    private void addImage(Image image){
        images.add(image);
    }

    private void deleteImage(Image image){
        images.add(image);
    }

}
