package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movements")
public class MovementController extends AbstractController<Movement, MovementDTO> {

    private MovementServiceImpl movementService;

    public MovementController(MovementServiceImpl movementService) {
        this.movementService = movementService;
    }

    @Override
    public AbstractService<Movement, MovementDTO> getService() {
        return movementService;
    }
}
