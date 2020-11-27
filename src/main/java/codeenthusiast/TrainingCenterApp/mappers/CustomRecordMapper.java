package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.record.custom.CustomRecord;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomRecordMapper {

    CustomRecordDTO mapToDTO(CustomRecord customRecord);

    CustomRecord mapToEntity(CustomRecordDTO customRecordDTO);

    List<CustomRecord> mapToEntities(List<CustomRecordDTO> customRecordDTOS);

    List<CustomRecordDTO> mapToDTOs(List<CustomRecord> customRecords);
}
