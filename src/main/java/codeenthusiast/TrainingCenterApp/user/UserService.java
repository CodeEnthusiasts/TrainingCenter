package codeenthusiast.TrainingCenterApp.user;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.user.major.User;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;

public interface UserService extends AbstractService<User, UserDTO> {
    
    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByUsername(String email);

    boolean existsByEmail(String username);

    void saveEntity(User user);

    UserDTO addImage(Long id, ImageDTO image);

    void removeImage(Long id);
}
