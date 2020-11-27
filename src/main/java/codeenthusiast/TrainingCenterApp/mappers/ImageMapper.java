package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageDTO mapToDTO(Image entity);

    @Mapping(target = "muscle", ignore = true)
    @Mapping(target = "movement", ignore = true)
    @Mapping(target = "user", ignore = true)
    Image mapToEntity(ImageDTO dto);

}
