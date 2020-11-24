package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.user.details.UserDetails;
import codeenthusiast.TrainingCenterApp.user.details.UserDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper extends AbstractMapper<UserDetails, UserDetailsDTO> {

    UserDetailsDTO mapToDTO(UserDetails userDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserDetails mapToEntity(UserDetailsDTO userDetailsDTO);

    List<UserDetails> mapToEntities(List<UserDetailsDTO> dtos);

    List<UserDetailsDTO> mapToDTOs(List<UserDetails> entities);
}
