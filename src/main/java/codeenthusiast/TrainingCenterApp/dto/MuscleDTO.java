package codeenthusiast.TrainingCenterApp.dto;

import codeenthusiast.TrainingCenterApp.entities.Image;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MuscleDTO {

    @NotNull
    @Length(min = 3, max = 48)
    private String name;

    @NotNull
    @Length(min = 3, max = 500)
    private String description;

    private List<Image> images;

    public MuscleDTO() {
    }

    public MuscleDTO(String name, String description, List<Image> images) {
        this.name = name;
        this.description = description;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
