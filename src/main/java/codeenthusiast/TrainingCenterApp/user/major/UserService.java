package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.image.ImageDTO;

public interface UserService {

    boolean existsByEmailAndPassword(String email, String password);

    UserDTO addImage(Long id, ImageDTO image);

    void removeImage(Long id);
}
