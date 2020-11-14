package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/priorities")
public class PriorityController extends AbstractController<Priority, PriorityDTO> {

    private PriorityServiceImpl priorityService;

    public PriorityController(PriorityServiceImpl priorityService) {
        this.priorityService = priorityService;
    }

    @Override
    public AbstractService<Priority, PriorityDTO> getService() {
        return priorityService;
    }
}
