package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement.KeyTechniqueElement;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement.KeyTechniqueElementDTO;
import codeenthusiast.TrainingCenterApp.user.User;
import codeenthusiast.TrainingCenterApp.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface KeyTechniqueElementMapper extends AbstractMapper<KeyTechniqueElement, KeyTechniqueElementDTO> {

    KeyTechniqueElementMapper INSTANCE = Mappers.getMapper(KeyTechniqueElementMapper.class);

    KeyTechniqueElementDTO mapToDto(KeyTechniqueElement entity);


    KeyTechniqueElement mapToEntity(KeyTechniqueElementDTO dto);

    default List<KeyTechniqueElement> mapToEntities(List<KeyTechniqueElementDTO> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    default List<KeyTechniqueElementDTO> mapToDTOs(List<KeyTechniqueElement> entieties) {
        return entieties.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
