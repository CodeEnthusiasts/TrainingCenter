package codeenthusiast.TrainingCenterApp.priority;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/priorities")
public class PriorityController {

    private PriorityServiceImpl priorityService;

    public PriorityController(PriorityServiceImpl priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PriorityDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(priorityService.findById(id));
    }

    @GetMapping(value = "/training-plan/{training_plan_id}")
    public ResponseEntity<List<PriorityDTO>> getAllByTrainingPlanId(@PathVariable("training_plan_id") Long id) {
        return ResponseEntity.ok(priorityService.getAllByTrainingPlanId(id));
    }

    @PostMapping(value = "/training-plan/{training_plan_id}")
    public ResponseEntity<PriorityDTO> create(@PathVariable("training_plan_id") Long id,
                                              @RequestBody @Valid PriorityDTO dto) {
        return ResponseEntity.ok(priorityService.create(id, dto));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<PriorityDTO> update(@PathVariable("id") Long id, @RequestBody @Valid PriorityDTO dto) {
        return ResponseEntity.ok(priorityService.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        priorityService.deleteById(id);
    }

}
