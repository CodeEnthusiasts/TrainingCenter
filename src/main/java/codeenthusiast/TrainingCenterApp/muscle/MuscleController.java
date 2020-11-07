package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muscles")
public class MuscleController extends AbstractController<Muscle, MuscleDTO> {

    private final MuscleServiceImpl muscleServiceImpl;

    public MuscleController(MuscleServiceImpl muscleServiceImpl) {
        this.muscleServiceImpl = muscleServiceImpl;
    }

    @Override
    public AbstractService<Muscle, MuscleDTO> getService() {
        return muscleServiceImpl;
    }

}
