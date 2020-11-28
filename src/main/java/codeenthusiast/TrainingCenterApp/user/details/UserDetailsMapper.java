package codeenthusiast.TrainingCenterApp.user.details;

import codeenthusiast.TrainingCenterApp.user.details.UserDetails;
import codeenthusiast.TrainingCenterApp.user.details.UserDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {

    UserDetailsDTO mapToDTO(UserDetails userDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserDetails mapToEntity(UserDetailsDTO userDetailsDTO);

}
