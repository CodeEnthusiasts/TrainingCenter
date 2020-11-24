package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecord;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StrengthRecordMapper {

    @Mapping(target = "repetition", ignore = true)
    @Mapping(target = "setDate", ignore = true)
    StrengthRecordDTO mapToDTO(StrengthRecord entity);

    @Mapping(target = "reps", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "personalRecords", ignore = true)
    StrengthRecord mapToEntity(StrengthRecordDTO entities);

    List<StrengthRecordDTO> mapToDTOs(List<StrengthRecord> strengthRecords);
}
