package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.user.major.User;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {UserDetailsMapper.class})
public interface UserMapper extends AbstractMapper<User, UserDTO> {


    @Mapping(target = "imageUrl", source = "image.fileUrl")
    @Mapping(target = "userDetailsDTO", source = "userDetails")
    UserDTO mapToDTO(User entity);

    User mapToEntity(UserDTO userDTO);

    List<UserDTO> mapToDTOs(List<User> entities);
}
