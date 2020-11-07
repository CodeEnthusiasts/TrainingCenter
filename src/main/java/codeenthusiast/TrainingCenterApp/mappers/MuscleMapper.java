package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import codeenthusiast.TrainingCenterApp.muscle.MuscleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MuscleMapper extends AbstractMapper<Muscle, MuscleDTO> {


    /*@Mapping(source = "images", target = "imagesDTO")*/
    MuscleDTO mapToDto(Muscle entity);

    /*@Mapping(source = "imagesDTO", target = "images")*/
    Muscle mapToEntity(MuscleDTO dto);

    List<Muscle> mapToEntities(List<MuscleDTO> dtos);

//    List<MuscleDTO> mapToDtos(List<Muscle> entities);
}
