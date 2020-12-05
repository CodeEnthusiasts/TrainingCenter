package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StrengthExerciseDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(strengthExerciseService.findById(id));
    }

    @GetMapping(value = "/training-session/{id}")
    public ResponseEntity<List<StrengthExerciseDTO>> getAllByTrainingPlanId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(strengthExerciseService.getAllByTrainingSessionId(id));
    }


    @PostMapping(value = "/training-session/{training_session_id}/movement/{movement_id}")
    public ResponseEntity<StrengthExerciseDTO> create(@RequestBody @Valid StrengthExerciseDTO dto
            , @PathVariable("training_session_id") Long trainingSessionId, @PathVariable("movement_id") Long movementId) {
        return ResponseEntity.ok(strengthExerciseService.create(dto, trainingSessionId, movementId));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<StrengthExerciseDTO> update(@PathVariable("id") Long id, @RequestBody @Valid StrengthExerciseDTO dto) {
        return ResponseEntity.ok(strengthExerciseService.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        strengthExerciseService.deleteById(id);
    }

}

