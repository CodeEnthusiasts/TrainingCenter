package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details.StrengthExerciseDetails;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details.StrengthExerciseDetailsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StrengthExerciseDetailsMapper
        extends AbstractMapper<StrengthExerciseDetails, StrengthExerciseDetailsDTO> {

    StrengthExerciseDetailsDTO mapToDTO(StrengthExerciseDetails strengthExerciseDetails);

    StrengthExerciseDetails mapToEntity(StrengthExerciseDetailsDTO strengthExerciseDetailsDTO);

}
