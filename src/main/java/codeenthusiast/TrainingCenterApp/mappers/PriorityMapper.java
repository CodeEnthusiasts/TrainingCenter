package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.priority.Priority;
import codeenthusiast.TrainingCenterApp.priority.PrioritySuperficialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PriorityMapper {

    PriorityMapper INSTANCE = Mappers.getMapper(PriorityMapper.class);

    PrioritySuperficialDTO mapToDTO(Priority priority);

    default List<PrioritySuperficialDTO> mapToDTOs(List<Priority> priorities) {
        return priorities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
