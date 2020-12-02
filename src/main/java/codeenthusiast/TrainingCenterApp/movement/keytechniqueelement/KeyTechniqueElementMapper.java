package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KeyTechniqueElementMapper {

    KeyTechniqueElementDTO mapToDTO(KeyTechniqueElement entity);

    @Mapping(target = "movement", ignore = true)
    KeyTechniqueElement mapToEntity(KeyTechniqueElementDTO dto);

    List<KeyTechniqueElementDTO> mapToEntities(List<KeyTechniqueElement> keyTechniqueElementList);
}
