package codeenthusiast.TrainingCenterApp.services;
//
//import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
//import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
//import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
//import codeenthusiast.TrainingCenterApp.user.major.UserMapper;
//import codeenthusiast.TrainingCenterApp.user.major.UserRepository;
//import codeenthusiast.TrainingCenterApp.user.major.UserServiceImpl;
//import codeenthusiast.TrainingCenterApp.user.major.User;
//import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//
//public class UserServiceImplTest  {
//
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private UserMapper userMapper;
//
//    @Override
//    AbstractRepository<User> getRepository() {
//        return userRepository;
//    }
//
//    @Override
//    Class<UserDTO> getDTOClass() {
//        return UserDTO.class;
//    }
//
//    @Override
//    Class<User> getEntityClass() {
//        return User.class;
//    }
//}