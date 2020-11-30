package codeenthusiast.TrainingCenterApp.user.details;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends AbstractRepository<UserDetails> {

    UserDetails findByUserId(Long id);

    UserDetails findById(long id);

}
