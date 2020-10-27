package codeenthusiast.TrainingCenterApp.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface AbstractMapper<ENTITY, DTO> {

    DTO mapToDTO(ENTITY entity);

    ENTITY mapToEntity(DTO dto);

    default List<ENTITY> mapToEntities(List<DTO> dtos){
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    default List<DTO> mapToDTOs(List<ENTITY> entities){
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
