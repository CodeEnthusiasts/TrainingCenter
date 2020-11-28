package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.record.custom.CustomRecord;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomRecordMapper {

    CustomRecordDTO mapToDTO(CustomRecord customRecord);

    @Mapping(target = "personalRecords", ignore = true)
    CustomRecord mapToEntity(CustomRecordDTO customRecordDTO);

    List<CustomRecord> mapToEntities(List<CustomRecordDTO> customRecordDTOS);

    List<CustomRecordDTO> mapToDTOs(List<CustomRecord> customRecords);
}
