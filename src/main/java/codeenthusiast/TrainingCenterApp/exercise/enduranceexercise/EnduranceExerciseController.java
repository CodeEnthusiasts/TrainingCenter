package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/endurance-exercises")
public class EnduranceExerciseController {

    private EnduranceExerciseServiceImpl enduranceExerciseService;

    public EnduranceExerciseController(EnduranceExerciseServiceImpl enduranceExerciseService) {
        this.enduranceExerciseService = enduranceExerciseService;
    }

    @GetMapping(value = "/{id}")
    public EnduranceExerciseDTO getById(@PathVariable("id") Long id) {
        return enduranceExerciseService.findById(id);
    }

    @GetMapping(value = "training-session/{id}")
    public List<EnduranceExerciseDTO> getAllByTrainingPlanId(@PathVariable("id") Long id) {
        return enduranceExerciseService.getAllByTrainingSessionId(id);
    }


    @PostMapping(value = "/training-session/{training_session_id}/movement/{movement_id}")
    public EnduranceExerciseDTO create(@RequestBody @Valid EnduranceExerciseDTO dto
            , @PathVariable("training_session_id") Long trainingSessionId, @PathVariable("movement_id") Long movementId) {
        return enduranceExerciseService.create(dto, trainingSessionId, movementId);
    }

    @PatchMapping(value = "/{id}")
    public EnduranceExerciseDTO update(@PathVariable("id") Long id, @RequestBody @Valid EnduranceExerciseDTO dto) {
        return enduranceExerciseService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        enduranceExerciseService.deleteById(id);
    }
}
