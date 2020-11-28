package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StrengthExerciseMapper {

    StrengthExerciseDTO mapToDTO(StrengthExercise strengthExercise);

    @Mapping(target = "movement", ignore = true)
    @Mapping(target = "trainingSession", ignore = true)
    StrengthExercise mapToEntity(StrengthExerciseDTO strengthExerciseDTO);

    List<StrengthExercise> mapToEntities(List<StrengthExerciseDTO> strengthExerciseDTOS);

    List<StrengthExerciseDTO> mapToDTOs(List<StrengthExercise> strengthExercises);
}
