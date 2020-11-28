package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.image.ImageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ImageMapper.class})
public interface MuscleMapper {


    MuscleDTO mapToDTO(Muscle entity);

    @Mapping(target = "movement", ignore = true)
    Muscle mapToEntity(MuscleDTO muscleDTO);

    List<MuscleDTO> mapToDTOs(List<Muscle> entities);
}
