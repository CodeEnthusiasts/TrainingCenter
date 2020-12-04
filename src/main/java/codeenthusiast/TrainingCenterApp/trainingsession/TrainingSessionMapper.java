package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.exercise.enduranceexercise.EnduranceExerciseMapper;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring", uses =
        {StrengthExerciseMapper.class, EnduranceExerciseMapper.class})
public interface TrainingSessionMapper {

    TrainingSessionDTO mapToDTO(TrainingSession trainingSession);

    @Mapping(target = "trainingPlan", ignore = true)
    TrainingSession mapToEntity(TrainingSessionDTO trainingSessionDTO);

    List<TrainingSession> mapToEntities(List<TrainingSessionDTO> dtos);

    List<TrainingSessionDTO> mapToDTOs(List<TrainingSession> entities);
}
