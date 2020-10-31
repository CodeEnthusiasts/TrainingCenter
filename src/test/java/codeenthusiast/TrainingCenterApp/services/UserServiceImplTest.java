package codeenthusiast.TrainingCenterApp.services;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.UserMapper;
import codeenthusiast.TrainingCenterApp.user.UserRepository;
import codeenthusiast.TrainingCenterApp.user.UserServiceImpl;
import codeenthusiast.TrainingCenterApp.user.major.User;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class UserServiceImplTest extends AbstractServiceImplTest<User, UserDTO> {


    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;


    @Override
    AbstractServiceImpl<User, UserDTO> getService() {
        return userService;
    }

    @Override
    AbstractRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    AbstractMapper<User, UserDTO> getMapper() {
        return userMapper;
    }

    @Override
    Class<UserDTO> getDTOClass() {
        return UserDTO.class;
    }

    @Override
    Class<User> getEntityClass() {
        return User.class;
    }
}