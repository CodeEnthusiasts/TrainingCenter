package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecord;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnduranceRecordMapper {

    EnduranceRecordDTO mapToDTO(EnduranceRecord enduranceRecord);

    @Mapping(target = "personalRecords", ignore = true)
    EnduranceRecord mapToEntity(EnduranceRecordDTO enduranceRecordDTO);

    List<EnduranceRecord> mapToEntities(List<EnduranceRecordDTO> enduranceRecordDTOS);

    List<EnduranceRecordDTO> mapToDTOs(List<EnduranceRecord> enduranceRecords);
}
