package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.stereotype.Service;

@Service
public interface KeyTechniqueElementService extends AbstractService<KeyTechniqueElement, KeyTechniqueElementDTO> {

    boolean existsById(Long id);

}
