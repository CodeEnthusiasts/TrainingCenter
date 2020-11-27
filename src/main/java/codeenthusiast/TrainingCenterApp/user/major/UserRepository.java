package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.user.role.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User> {

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
