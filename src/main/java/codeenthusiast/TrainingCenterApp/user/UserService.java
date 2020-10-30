package codeenthusiast.TrainingCenterApp.user;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;

public interface UserService extends AbstractService<User, UserDTO> {

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByUsername(String email);

    boolean existsByEmail(String username);

    void saveEntity(User user);
}
