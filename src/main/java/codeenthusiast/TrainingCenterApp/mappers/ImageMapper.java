package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ImageMapper extends AbstractMapper<Image, ImageDTO> {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);


    ImageDTO mapToDto(Image entity);


    Image mapToEntity(ImageDTO dto);

    default List<Image> mapToEntieties(List<ImageDTO> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    default List<ImageDTO> mapToDtos(List<Image> entieties) {
        return entieties.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
