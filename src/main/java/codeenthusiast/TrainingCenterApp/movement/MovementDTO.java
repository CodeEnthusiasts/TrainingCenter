package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.muscle.MuscleDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovementDTO extends AbstractDTO {

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @JsonIgnore
    private List<ImageDTO> images;

    @JsonIgnore
    private List<MuscleDTO> muscles;

    public MovementDTO(String name) {
        this.name = name;
    }
}
