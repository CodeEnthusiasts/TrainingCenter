package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement.KeyTechniqueElement;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement.KeyTechniqueElementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface KeyTechniqueElementMapper extends AbstractMapper<KeyTechniqueElement, KeyTechniqueElementDTO> {

    KeyTechniqueElementMapper INSTANCE = Mappers.getMapper(KeyTechniqueElementMapper.class);

    KeyTechniqueElementDTO mapToDTO(KeyTechniqueElement entity);


    KeyTechniqueElement mapToEntity(KeyTechniqueElementDTO dto);

    List<KeyTechniqueElement> mapToEntities(List<KeyTechniqueElementDTO> dtos);

    List<KeyTechniqueElementDTO> mapToDTOs(List<KeyTechniqueElement> entities);
}
