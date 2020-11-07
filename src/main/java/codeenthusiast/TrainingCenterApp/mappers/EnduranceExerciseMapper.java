package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExercise;
import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExerciseDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EnduranceExerciseMapper extends AbstractMapper<EnduranceExercise, EnduranceExerciseDTO> {

    EnduranceExerciseDTO mapToDTO(EnduranceExercise enduranceExercise);

    EnduranceExercise mapToEntity(EnduranceExerciseDTO enduranceExerciseDTO);

    List<EnduranceExercise> mapToEntities(List<EnduranceExerciseDTO> enduranceExerciseDTOS);

    List<EnduranceExerciseDTO> mapToDTOs(List<EnduranceExercise> enduranceExercises);
}
