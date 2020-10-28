package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyTechniqueElementController extends AbstractController<KeyTechniqueElement, KeyTechniqueElementDTO> {

    private final KeyTechniqueElementServiceImpl keyTechniqueElementService;

    public KeyTechniqueElementController(KeyTechniqueElementServiceImpl keyTechniqueElementService) {
        this.keyTechniqueElementService = keyTechniqueElementService;
    }

    @Override
    public AbstractService<KeyTechniqueElement, KeyTechniqueElementDTO> getService() {
        return keyTechniqueElementService;
    }
}
