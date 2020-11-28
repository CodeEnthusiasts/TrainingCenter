package codeenthusiast.TrainingCenterApp.user.role;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.constants.ERole;
import codeenthusiast.TrainingCenterApp.user.role.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends AbstractRepository<Role> {
    Optional<Role> findByName(ERole name);
}
