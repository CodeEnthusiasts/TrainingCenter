package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public UserDTO save(User user) {
        User savedUser = userRepository.save(user);
        return userMapper.mapToDTO(savedUser);
    }

    public UserDTO update(Long id, UserDTO dto) {
        User user = findEntityById(id);
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        if(dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }

        return save(user);
    }

    public User findEntityById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    public String addImage(Long id, MultipartFile file) {
        User user = findEntityById(id);
        if (!imageService.existsByUserId(id)){
            imageService.createNewImage(file, user);
        } else{
            Image image = user.getImage();
            imageService.replaceUserImage(image, file);
        }

        return "Image was successfully added";
    }

    @Override
    @Transactional
    public String removeImage(Long id) {
        User user = findEntityById(id);
        user.setImage(null);
        imageService.deleteImageByUserId(id);

        return "Image was deleted successfully";
    }

}
