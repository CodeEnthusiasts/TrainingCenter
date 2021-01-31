package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ImageServiceImpl imageService;
    private final UserMapper userMapper;


    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, ImageServiceImpl imageService) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.imageService = imageService;
    }

    @Override
    public User findEntityById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    @Override
    public UserDTO findById(Long id) {
        return mapToDTO(findEntityById(id));
    }

    @Override
    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        User user = findEntityById(id);
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        if(dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }

        log.info("Update user data of ID {}", id);
        return mapToDTO(user);
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    @Transactional
    public String addImage(Long id, MultipartFile file) {
        User user = findEntityById(id);
        if (!imageService.existsByUserId(id)){
            imageService.createNewImage(file, user);
        } else{
            Image image = user.getImage();
            imageService.replaceImage(image, file);
        }
        log.info("Added image to user of ID {}", id);

        return "Image was successfully added";
    }

    @Override
    @Transactional
    public String removeImage(Long id) {
        User user = findEntityById(id);
        user.setImage(null);
        imageService.deleteImageByUserId(id);

        log.info("Removed image to user of ID {}", id);

        return "Image was deleted successfully";
    }

    private User save(User user) {
        return userRepository.save(user);
    }

    private UserDTO mapToDTO(User user) {
        return userMapper.mapToDTO(user);
    }

}
