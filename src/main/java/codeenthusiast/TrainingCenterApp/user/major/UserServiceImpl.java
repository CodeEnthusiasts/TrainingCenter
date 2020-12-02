package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ImageServiceImpl imageService;
    private final UserMapper userMapper;


    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, ImageServiceImpl imageService) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.imageService = imageService;
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

    public UserDTO addImage(Long id, MultipartFile file) {
        User user = findEntityById(id);
        imageService.createNewUserImage(user, file);
        return userMapper.mapToDTO(user);
    }

    @Override
    public void removeImage(Long id) {
       imageService.deleteImagesByUserId(id);
    }

}
