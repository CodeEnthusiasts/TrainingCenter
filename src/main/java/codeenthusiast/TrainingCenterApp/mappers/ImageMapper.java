package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ImageMapper extends AbstractMapper<Image, ImageDTO>{

    ImageDTO mapToDTO(Image entity);

    @Mapping(target = "muscle", ignore = true)
    @Mapping(target = "movement", ignore = true)
    @Mapping(target = "user", ignore = true)
    Image mapToEntity(ImageDTO dto);

    List<Image> mapToEntities(List<ImageDTO> dtos);

    List<ImageDTO> mapToDTOs(List<Image> entities);
}
