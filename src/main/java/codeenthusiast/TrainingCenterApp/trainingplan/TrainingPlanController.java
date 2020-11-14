package codeenthusiast.TrainingCenterApp.trainingplan;


import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/training_plans")
public class TrainingPlanController {

    private TrainingPlanService trainingPlanService;

    public TrainingPlanController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @GetMapping(value = "/{id}")
    public TrainingPlanSuperficialDTO getById(@PathVariable("id") Long id) {
        return trainingPlanService.findById(id);
    }

    @GetMapping(value = "/all")
    public List<TrainingPlanSuperficialDTO> getAll() {
        return trainingPlanService.getAll();
    }

    @PostMapping
    public TrainingPlanDTO create(@RequestBody @Valid TrainingPlanDTO dto) {
        return trainingPlanService.save(dto);
    }

    @PutMapping(value = "/{id}")
    public TrainingPlanDTO update(@PathVariable("id") Long id, @RequestBody @Valid TrainingPlanDTO dto) {
        return trainingPlanService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        trainingPlanService.delete(id);
    }

}
