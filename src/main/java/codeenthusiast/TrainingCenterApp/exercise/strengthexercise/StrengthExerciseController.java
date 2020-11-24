package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/strength-exercises")
public class StrengthExerciseController {

    private StrengthExerciseServiceImpl strengthExerciseService;

    public StrengthExerciseController(StrengthExerciseServiceImpl strengthExerciseService) {
        this.strengthExerciseService = strengthExerciseService;
    }

    @GetMapping(value = "/{id}")
    public StrengthExerciseDTO getById(@PathVariable("id") Long id) {
        return strengthExerciseService.findById(id);
    }

    @GetMapping(value = "training-plan/{id}")
    public List<StrengthExerciseDTO> getAllByTrainingPlanId(@PathVariable("id") Long id) {
        return strengthExerciseService.getAllByTrainingSessionId(id);
    }


    @PostMapping(value = "/training-plan/{training_plan_id}/movement/{movement_id}")
    public StrengthExerciseDTO create(@RequestBody @Valid StrengthExerciseDTO dto
            , @PathVariable("training_plan_id") Long trainingPlanId, @PathVariable("movement_id") Long movementId) {
        return strengthExerciseService.create(dto, trainingPlanId, movementId);
    }

    @PatchMapping(value = "/{id}")
    public StrengthExerciseDTO update(@PathVariable("id") Long id, @RequestBody @Valid StrengthExerciseDTO dto) {
        return strengthExerciseService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        strengthExerciseService.deleteById(id);
    }

}

