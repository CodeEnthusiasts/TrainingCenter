package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.image.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MuscleDTO extends AbstractDTO {

    private String name;
    private String description;
    private String imageUrl;
    private List<Image> images;

    public MuscleDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
