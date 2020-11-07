package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.image.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "muscles")
@Getter
@Setter
@NoArgsConstructor
public class Muscle extends AbstractEntity {

    @NonNull
    @Length(min = 3, max = 48)
    private String name;

    @NonNull
    @Length(min = 3, max = 500)
    private String description;

    @OneToMany
    private List<Image> images;

    public Muscle(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Muscle(MuscleDTO muscleDTO) {
        name = muscleDTO.getName();
        description = muscleDTO.getDescription();
        images = muscleDTO.getImages();
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void removeImage(Image image) {
        images.remove(image);
    }

    public void removeAllImages() {
        images.clear();
    }
}
