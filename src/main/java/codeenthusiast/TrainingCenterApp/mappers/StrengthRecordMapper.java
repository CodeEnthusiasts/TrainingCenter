package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecord;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface StrengthRecordMapper extends AbstractMapper<StrengthRecord, StrengthRecordDTO> {

    List<StrengthRecordDTO> mapToDTOs(List<StrengthRecord> strengthRecords);

}
