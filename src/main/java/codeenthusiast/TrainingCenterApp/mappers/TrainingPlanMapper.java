package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanSuperficialDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {PriorityMapper.class})
public interface TrainingPlanMapper extends AbstractMapper<TrainingPlan, TrainingPlanSuperficialDTO> {


    TrainingPlanSuperficialDTO mapToDTO(TrainingPlan entity);

    default List<TrainingPlanSuperficialDTO> mapToDTOs(List<TrainingPlan> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
