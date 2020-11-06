package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pace")
public class PaceController extends AbstractController<Pace, PaceDTO> {

    private PaceServiceImpl paceService;

    public PaceController(PaceServiceImpl paceService) {
        this.paceService = paceService;
    }

    @Override
    public AbstractService<Pace, PaceDTO> getService() {
        return paceService;
    }
}
