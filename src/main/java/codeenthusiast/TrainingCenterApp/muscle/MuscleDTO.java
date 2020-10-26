package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.image.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MuscleDTO extends AbstractDTO {

    private String name;
    private String description;
    private List<Image> images = new ArrayList<>();

}
