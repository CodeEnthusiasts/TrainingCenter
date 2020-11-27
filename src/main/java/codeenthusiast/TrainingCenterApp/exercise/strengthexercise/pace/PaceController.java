package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pace")
public class PaceController {

    private PaceServiceImpl paceService;

    public PaceController(PaceServiceImpl paceService) {
        this.paceService = paceService;
    }



    //create

}
