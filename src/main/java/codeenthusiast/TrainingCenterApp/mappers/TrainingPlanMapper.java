package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.training.TrainingPlan;
import codeenthusiast.TrainingCenterApp.training.TrainingPlanSuperficialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TrainingPlanMapper  {

    TrainingPlanMapper INSTANCE = Mappers.getMapper(TrainingPlanMapper.class);


    TrainingPlanSuperficialDTO mapToDTO(TrainingPlan trainingPlan);
}
