package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.priority.PriorityDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PriorityMapper extends AbstractMapper<Priority, PriorityDTO> {

    PriorityDTO mapToDTO(Priority priority);

    List<PriorityDTO> mapToDTOs(List<Priority> priorities);
}
