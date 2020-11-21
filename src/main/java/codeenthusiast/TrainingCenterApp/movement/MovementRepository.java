package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends AbstractRepository<Movement> {
    boolean existsByName(String name);
}
