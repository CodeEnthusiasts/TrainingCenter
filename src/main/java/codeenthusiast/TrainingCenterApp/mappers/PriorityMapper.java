package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.priority.PriorityDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriorityMapper {

    PriorityDTO mapToDTO(Priority priority);

    Priority mapToEntity(PriorityDTO priorityDTO);

    List<PriorityDTO> mapToDTOs(List<Priority> allByTrainingPlanId);
}
