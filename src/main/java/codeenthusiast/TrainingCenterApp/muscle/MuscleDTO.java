package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MuscleDTO extends AbstractDTO {

    @NonNull
    @Length(min = 3, max = 100)
    private String name;

    @NonNull
    @Length(min = 5, max = 500)
    private String description;

    private List<ImageDTO> images;

    public MuscleDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
