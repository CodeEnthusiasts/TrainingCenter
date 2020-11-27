package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {

    @Mapping(target = "muscles", ignore = true)
    MovementDTO mapToDTO(Movement movement);

    @Mapping(target = "musclesInvolved", ignore = true)
    @Mapping(target = "keyTechniqueElements", ignore = true)
    Movement mapToEntity(MovementDTO movementDTO);

    List<Movement> mapToEntities(List<MovementDTO> movementDTOS);


}
