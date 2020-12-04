package codeenthusiast.TrainingCenterApp.user.major;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User findEntityById(Long id);

    UserDTO findById(Long id);

    UserDTO update(Long id, UserDTO dto);

    boolean existsByEmailAndPassword(String email, String password);

    String addImage(Long id, MultipartFile file);

    String removeImage(Long id);
}
