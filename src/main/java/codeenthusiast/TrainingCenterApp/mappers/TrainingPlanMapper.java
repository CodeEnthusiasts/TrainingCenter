package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecord;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordDTO;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainingPlanMapper extends AbstractMapper<TrainingPlan, TrainingPlanDTO> {

    TrainingPlanDTO mapToDTO(TrainingPlan entity);

    List<TrainingPlanDTO> mapToDTOs(List<TrainingPlan> entities);

    @Mapping(ignore = true, target = "numberOfExecutedTrainings")
    TrainingPlan mapToEntity(TrainingPlanDTO dto);

    List<TrainingPlan> mapToEntities(List<TrainingPlanDTO> entities);
    
}
