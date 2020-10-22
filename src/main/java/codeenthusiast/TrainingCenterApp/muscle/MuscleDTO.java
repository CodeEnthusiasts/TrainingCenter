package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.image.Image;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class MuscleDTO {

    @NonNull
    @Length(min = 3, max = 48)
    private String name;

    @NonNull
    @Length(min = 3, max = 500)
    private String description;

    private List<Image> images = new ArrayList<>();

}
