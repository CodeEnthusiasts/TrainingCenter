package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.priority.PriorityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriorityMapper {

    PriorityDTO mapToDTO(Priority priority);

    @Mapping(target = "trainingPlan", ignore = true)
    Priority mapToEntity(PriorityDTO priorityDTO);

    List<PriorityDTO> mapToDTOs(List<Priority> allByTrainingPlanId);
}
