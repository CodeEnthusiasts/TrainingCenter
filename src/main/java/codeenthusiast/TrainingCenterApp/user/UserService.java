package codeenthusiast.TrainingCenterApp.user;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.user.major.User;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;

public interface UserService extends AbstractService<User, UserDTO> {

    boolean existsByEmailAndPassword(String email, String password);

    UserDTO addImage(Long id, ImageDTO image);

    void removeImage(Long id);
}
