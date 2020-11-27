package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import codeenthusiast.TrainingCenterApp.muscle.MuscleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MuscleMapper {


    MuscleDTO mapToDTO(Muscle entity);

    @Mapping(target = "movement", ignore = true)
    Muscle mapToEntity(MuscleDTO muscleDTO);

    List<MuscleDTO> mapToDTOs(List<Muscle> entities);
}
