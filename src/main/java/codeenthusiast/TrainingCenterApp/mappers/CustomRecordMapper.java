package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecord;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomRecordMapper extends AbstractMapper<CustomRecord, CustomRecordDTO> {
}
