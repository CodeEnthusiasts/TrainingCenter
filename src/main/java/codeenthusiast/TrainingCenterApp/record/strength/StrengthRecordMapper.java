package codeenthusiast.TrainingCenterApp.record.strength;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StrengthRecordMapper {

    StrengthRecordDTO mapToDTO(StrengthRecord entity);

    @Mapping(target = "personalRecords", ignore = true)
    StrengthRecord mapToEntity(StrengthRecordDTO entities);

    List<StrengthRecordDTO> mapToDTOs(List<StrengthRecord> strengthRecords);
}
