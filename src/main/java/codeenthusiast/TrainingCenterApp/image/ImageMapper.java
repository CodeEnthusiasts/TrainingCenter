package codeenthusiast.TrainingCenterApp.image;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageDTO mapToDTO(Image entity);

    @Mapping(target = "muscle", ignore = true)
    @Mapping(target = "movement", ignore = true)
    @Mapping(target = "user", ignore = true)
    Image mapToEntity(ImageDTO dto);

}
