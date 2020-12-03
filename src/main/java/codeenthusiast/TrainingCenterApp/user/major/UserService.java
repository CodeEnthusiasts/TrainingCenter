package codeenthusiast.TrainingCenterApp.user.major;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    boolean existsByEmailAndPassword(String email, String password);

    String addImage(Long id, MultipartFile file);

    String removeImage(Long id);
}
