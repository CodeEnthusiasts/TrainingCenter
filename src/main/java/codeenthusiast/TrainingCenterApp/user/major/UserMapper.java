package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.user.role.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "imageUrl", source = "image.fileUrl")
    @Mapping(target = "userDetailsDTO", source = "userDetails")
    UserDTO mapToDTO(User entity);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "userDetails", ignore = true)
    @Mapping(target = "trainingPlans", ignore = true)
    @Mapping(target = "personalRecords", ignore = true)
    User mapToEntity(UserDTO userDTO);

}
