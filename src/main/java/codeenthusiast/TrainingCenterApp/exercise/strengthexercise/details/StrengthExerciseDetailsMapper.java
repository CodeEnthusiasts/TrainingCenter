package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StrengthExerciseDetailsMapper {

    StrengthExerciseDetailsDTO mapToDTO(StrengthExerciseDetails strengthExerciseDetails);

    @Mapping(target = "strengthExercise", ignore = true)
    StrengthExerciseDetails mapToEntity(StrengthExerciseDetailsDTO strengthExerciseDetailsDTO);

}
