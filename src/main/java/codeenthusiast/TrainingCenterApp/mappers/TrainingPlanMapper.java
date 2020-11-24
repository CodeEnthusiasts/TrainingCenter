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

    List<TrainingPlanSuperficialDTO> mapToSuperficialDTOs(List<TrainingPlan> entities);

    TrainingPlanDTO mapToDTO(TrainingPlan entity);

    List<TrainingPlanDTO> mapToDTOs(List<TrainingPlan> entities);

    @Mapping(ignore = true, target = "user")
    TrainingPlan mapToEntity(TrainingPlanDTO dto);

    List<TrainingPlan> mapToEntities(List<TrainingPlanDTO> entities);

}
