package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.movement.keytechniqueelement.KeyTechniqueElement;
import codeenthusiast.TrainingCenterApp.movement.keytechniqueelement.KeyTechniqueElementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KeyTechniqueElementMapper {

    KeyTechniqueElementDTO mapToDTO(KeyTechniqueElement entity);

    @Mapping(target = "movement", ignore = true)
    KeyTechniqueElement mapToEntity(KeyTechniqueElementDTO dto);

}
