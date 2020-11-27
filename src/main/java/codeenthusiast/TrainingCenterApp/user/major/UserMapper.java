package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
import codeenthusiast.TrainingCenterApp.user.role.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "imageUrl", source = "image.fileUrl")
    @Mapping(target = "userDetailsDTO", source = "userDetails")
    UserDTO mapToDTO(User entity);

    User mapToEntity(UserDTO userDTO);

}
