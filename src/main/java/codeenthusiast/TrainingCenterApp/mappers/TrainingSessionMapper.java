package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "Spring")
public interface TrainingSessionMapper  {

    TrainingSessionDTO mapToDTO(TrainingSession trainingSession);

    @Mapping(target = "trainingPlan", ignore = true)
    TrainingSession mapToEntity(TrainingSessionDTO trainingSessionDTO);

    List<TrainingSession> mapToEntities(List<TrainingSessionDTO> dtos);

    List<TrainingSessionDTO> mapToDTOs(List<TrainingSession> entities);
}
