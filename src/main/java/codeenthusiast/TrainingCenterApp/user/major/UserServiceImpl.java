package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.user.role.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        return userMapper.mapToDTO(user);
    }

    public UserDTO save(UserDTO dto) {
        User user = userMapper.mapToEntity(dto);
        userRepository.save(user);
        return dto;
    }

    public UserDTO update(Long id, UserDTO dto) {
        User user = findEntityById(id);
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        if(dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }

        return save(userMapper.mapToDTO(user));
    }

    public User findEntityById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

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
