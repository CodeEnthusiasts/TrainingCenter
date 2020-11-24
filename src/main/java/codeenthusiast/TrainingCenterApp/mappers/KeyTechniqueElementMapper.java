package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.movement.keytechniqueelement.KeyTechniqueElement;
import codeenthusiast.TrainingCenterApp.movement.keytechniqueelement.KeyTechniqueElementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KeyTechniqueElementMapper extends AbstractMapper<KeyTechniqueElement, KeyTechniqueElementDTO>{

    KeyTechniqueElementDTO mapToDTO(KeyTechniqueElement entity);

    @Mapping(target = "movement", ignore = true)
    KeyTechniqueElement mapToEntity(KeyTechniqueElementDTO dto);

    List<KeyTechniqueElement> mapToEntities(List<KeyTechniqueElementDTO> dtos);

    List<KeyTechniqueElementDTO> mapToDTOs(List<KeyTechniqueElement> entities);
}
