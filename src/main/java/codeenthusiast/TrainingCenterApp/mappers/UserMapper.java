package codeenthusiast.TrainingCenterApp.mappers;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.user.User;
import codeenthusiast.TrainingCenterApp.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<User, UserDTO> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "imageUrl", source = "image.fileUrl")
    UserDTO mapToDTO(User entity);

    User mapToEntity(UserDTO dto);

    default List<User> mapToEntities(List<UserDTO> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    default List<UserDTO> mapToDTOs(List<User> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
