package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import codeenthusiast.TrainingCenterApp.muscle.MuscleDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MuscleMapper extends AbstractMapper<Muscle, MuscleDTO> {


    MuscleDTO mapToDTO(Muscle entity);

    Muscle mapToEntity(MuscleDTO muscleDTO);

    List<MuscleDTO> mapToDTOs(List<Muscle> entities);
}
