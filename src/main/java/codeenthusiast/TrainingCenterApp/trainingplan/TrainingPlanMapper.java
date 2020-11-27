package codeenthusiast.TrainingCenterApp.trainingplan;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainingPlanMapper {

    TrainingPlanDTO mapToDTO(TrainingPlan entity);

    List<TrainingPlanDTO> mapToDTOs(List<TrainingPlan> entities);

    @Mapping(ignore = true, target = "user")
    TrainingPlan mapToEntity(TrainingPlanDTO dto);

    List<TrainingPlan> mapToEntities(List<TrainingPlanDTO> entities);
    
}
