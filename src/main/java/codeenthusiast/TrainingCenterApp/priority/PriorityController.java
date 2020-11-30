package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.movement.keytechniqueelement.KeyTechniqueElementDTO;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/priorities")
public class PriorityController {

    private PriorityServiceImpl priorityService;

    public PriorityController(PriorityServiceImpl priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping(value = "/{id}")
    public PriorityDTO getById(@PathVariable("id") Long id) {
        return priorityService.findById(id);
    }

    @GetMapping(value = "/training-plan/{training_plan_id}")
    public List<PriorityDTO> getAllByTrainingPlanId(@PathVariable("training_plan_id") Long id){
        return priorityService.getAllByTrainingPlanId(id);
    }

    @PostMapping(value = "/training-plan/{training_plan_id}")
    public PriorityDTO create(@PathVariable("training_plan_id") Long id,
                                         @RequestBody @Valid PriorityDTO dto) {
        return priorityService.create(id, dto);
    }

    @PatchMapping(value = "/{id}")
    public PriorityDTO update(@PathVariable("id") Long id, @RequestBody @Valid PriorityDTO dto) {
        return priorityService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        priorityService.deleteById(id);
    }

}
