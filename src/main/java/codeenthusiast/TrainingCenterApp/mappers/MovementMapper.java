package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

//@Mapper(componentModel = "spring")
//public interface MovementMapper extends AbstractMapper<Movement, MovementDTO> {

//    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

//    @Override
//    MovementDTO mapToDTO(Movement movement);
//
//    @Override
//    @InheritInverseConfiguration(name = "mapToDTO")
//    Movement mapToEntity(MovementDTO movementDTO);
//
//    @Override
//    default List<Movement> mapToEntities(List<MovementDTO> movementDTOS) {
//        return movementDTOS.stream().map(this::mapToEntity).collect(Collectors.toList());
//    }
//
//    @Override
//    default List<MovementDTO> mapToDTOs(List<Movement> movements) {
//        return movements.stream().map(this::mapToDTO).collect(Collectors.toList());
//    }
//}
