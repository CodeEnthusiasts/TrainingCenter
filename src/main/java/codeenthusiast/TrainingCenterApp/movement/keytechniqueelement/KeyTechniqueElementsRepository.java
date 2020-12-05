package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyTechniqueElementsRepository extends AbstractRepository<KeyTechniqueElement> {

    List<KeyTechniqueElement> findAllByMovementId(Long movementId);
}
