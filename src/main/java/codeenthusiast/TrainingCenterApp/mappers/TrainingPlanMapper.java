package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanSuperficialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface TrainingPlanMapper {

    TrainingPlanMapper INSTANCE = Mappers.getMapper(TrainingPlanMapper.class);

    TrainingPlanSuperficialDTO mapToDTO(TrainingPlan trainingPlan);

    default List<TrainingPlanSuperficialDTO> mapToDTOs(List<TrainingPlan> trainingPlans) {
        return trainingPlans.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
