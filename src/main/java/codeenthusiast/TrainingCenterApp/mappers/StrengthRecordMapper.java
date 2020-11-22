package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecord;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordDTO;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StrengthRecordMapper extends AbstractMapper<StrengthRecord, StrengthRecordDTO> {

    StrengthRecordDTO mapToDTO(StrengthRecord entity);

    StrengthRecord mapToEntity(StrengthRecordDTO entities);

    List<StrengthRecordDTO> mapToDTOs(List<StrengthRecord> strengthRecords);

}
