package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.image.Image;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "muscles")
@Getter
@Setter
@NoArgsConstructor
public class Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany
    private List<Image> images = new ArrayList<>();

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
