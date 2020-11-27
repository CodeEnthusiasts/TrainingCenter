package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StrengthExerciseDetailsMapper {

    StrengthExerciseDetailsDTO mapToDTO(StrengthExerciseDetails strengthExerciseDetails);

    StrengthExerciseDetails mapToEntity(StrengthExerciseDetailsDTO strengthExerciseDetailsDTO);

}
