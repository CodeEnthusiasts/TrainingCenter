package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/training_sessions")
public class TrainingSessionController extends AbstractController<TrainingSession, TrainingSessionDTO> {

    private final TrainingSessionServiceImpl trainingSessionService;

    public TrainingSessionController(TrainingSessionServiceImpl trainingSessionService) {
        this.trainingSessionService = trainingSessionService;
    }

    @Override
    public AbstractService<TrainingSession, TrainingSessionDTO> getService() {
        return trainingSessionService;
    }
}
