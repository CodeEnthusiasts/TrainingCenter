package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/key_technique_elements")
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
