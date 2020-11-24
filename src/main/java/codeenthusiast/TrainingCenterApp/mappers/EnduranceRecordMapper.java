package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecord;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecordDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnduranceRecordMapper extends AbstractMapper<EnduranceRecord, EnduranceRecordDTO> {
}
