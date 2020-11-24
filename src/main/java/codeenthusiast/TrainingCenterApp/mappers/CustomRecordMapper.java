package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExercise;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExerciseDTO;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecord;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomRecordMapper {

    CustomRecordDTO mapToDTO(CustomRecord customRecord);

    CustomRecord mapToEntity(CustomRecordDTO customRecordDTO);

    List<CustomRecord> mapToEntities(List<CustomRecordDTO> customRecordDTOS);

    List<CustomRecordDTO> mapToDTOs(List<CustomRecord> customRecords);
}
