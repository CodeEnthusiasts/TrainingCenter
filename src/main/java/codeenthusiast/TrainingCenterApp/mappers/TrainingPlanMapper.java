package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanDTO;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanSuperficialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {PriorityMapper.class})
public interface TrainingPlanMapper {


    TrainingPlanSuperficialDTO mapToSuperficialDTO(TrainingPlan entity);

    default List<TrainingPlanSuperficialDTO> mapToSuperficialDTOs(List<TrainingPlan> entities) {
        return entities.stream().map(this::mapToSuperficialDTO).collect(Collectors.toList());
    }

    TrainingPlanDTO mapToDTO(TrainingPlan entity);

    default List<TrainingPlanDTO> mapToDTOs(List<TrainingPlan> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Mapping(ignore = true, target = "numberOfExecutedTrainings")
    TrainingPlan mapToEntity(TrainingPlanDTO dto);

    default List<TrainingPlan> mapToEntities(List<TrainingPlanDTO> entities) {
        return entities.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

}
