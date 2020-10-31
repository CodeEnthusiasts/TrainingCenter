package codeenthusiast.TrainingCenterApp.user;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.mappers.UserMapper;
import codeenthusiast.TrainingCenterApp.user.major.User;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserDTO> implements UserService {

    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserServiceImpl(AbstractRepository<User> repository, AbstractMapper<User,
            UserDTO> mapper, UserMapper userMapper, UserRepository userRepository) {
        super(repository, mapper);
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
    // THIS METHODS EXIST ONLY FOR SIMPLE SIGN-UP/IN implementation - will be deleted after adding security
    @Override
    public boolean existsByUsernameAndPassword(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    public boolean existsByUsername(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByEmail(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void saveEntity(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDTO addImage(Long id, ImageDTO image) {
        UserDTO user = findById(id);
        user.setImageUrl(image.getFileUrl());
        return save(user);
    }

    @Override
    public void removeImage(Long id) {
        UserDTO user = findById(id);
        user.setImageUrl(null);
        save(user);
    }
}
