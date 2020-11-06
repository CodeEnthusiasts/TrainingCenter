package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "Spring")
public interface TrainingSessionMapper extends AbstractMapper<TrainingSession, TrainingSessionDTO> {


    TrainingSessionDTO mapToDTO(TrainingSession trainingSession);


    TrainingSession mapToEntity(TrainingSessionDTO trainingSessionDTO);

    List<TrainingSession> mapToEntities(List<TrainingSessionDTO> dtos);

    List<TrainingSessionDTO> mapToDTOs(List<TrainingSession> entities);
}
