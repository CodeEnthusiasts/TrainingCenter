package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseDTO;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StrengthExerciseMapper extends AbstractMapper<StrengthExercise, StrengthExerciseDTO> {

    StrengthExerciseDTO mapToDTO(StrengthExercise strengthExercise);

    StrengthExercise mapToEntity(StrengthExerciseDTO strengthExerciseDTO);

    List<StrengthExercise> mapToEntities(List<StrengthExerciseDTO> strengthExerciseDTOS);

    List<StrengthExerciseDTO> mapToDTOs(List<StrengthExercise> strengthExercises);
}
