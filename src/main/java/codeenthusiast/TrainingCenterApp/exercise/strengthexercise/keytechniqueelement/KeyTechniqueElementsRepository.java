package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyTechniqueElementsRepository extends AbstractRepository<KeyTechniqueElement> {

    boolean existsByContent(String content);
}
