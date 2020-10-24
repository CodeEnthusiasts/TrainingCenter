package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.muscle.MuscleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementDTO {

    @NotNull
    private String name;

    private List<MuscleDTO> musclesInvolved;

    private List<ImageDTO> images;

}
