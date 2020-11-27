package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExercise;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExerciseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnduranceExerciseMapper {

    EnduranceExerciseDTO mapToDTO(EnduranceExercise enduranceExercise);

    @Mapping(target = "movement", ignore = true)
    @Mapping(target = "trainingSession", ignore = true)
    EnduranceExercise mapToEntity(EnduranceExerciseDTO enduranceExerciseDTO);

    List<EnduranceExercise> mapToEntities(List<EnduranceExerciseDTO> enduranceExerciseDTOs);

    List<EnduranceExerciseDTO> mapToDTOs(List<EnduranceExercise> enduranceExercises);
}
