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

    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

    UserDetailsDTO mapToDTO(UserDetails userDetails);

    UserDetails mapToEntity(UserDetailsDTO userDetailsDTO);

    List<UserDetails> mapToEntities(List<UserDetailsDTO> dtos);

    List<UserDetailsDTO> mapToDTOs(List<UserDetails> entities);
}
