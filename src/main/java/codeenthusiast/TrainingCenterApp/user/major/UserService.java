package codeenthusiast.TrainingCenterApp.user.major;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    boolean existsByEmailAndPassword(String email, String password);

    UserDTO addImage(Long id, MultipartFile file);

    void removeImage(Long id);
}
