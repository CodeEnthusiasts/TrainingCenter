package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace.Pace;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace.PaceDTO;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PaceMapper extends AbstractMapper<Pace, PaceDTO> {

    PaceDTO mapToDTO(Pace pace);

    Pace mapToEntity(PaceDTO paceDTO);

    List<Pace> mapToEntities(List<PaceDTO> paceDTOs);

    List<PaceDTO> mapToDTOs(List<Pace> paces);
}
