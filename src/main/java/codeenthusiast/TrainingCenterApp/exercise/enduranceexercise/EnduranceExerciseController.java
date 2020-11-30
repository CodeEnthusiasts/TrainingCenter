package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EnduranceExerciseController {

    private final EnduranceExerciseServiceImpl enduranceExerciseService;

    public EnduranceExerciseController(EnduranceExerciseServiceImpl enduranceExerciseService) {
        this.enduranceExerciseService = enduranceExerciseService;
    }

    @GetMapping(value = "/endurance-exercises/{endurance_exercise_id}")
    public ResponseEntity<EnduranceExerciseDTO> getEnduranceExerciseById(
            @PathVariable("endurance_exercise_id") Long enduranceExerciseId) {
        return ResponseEntity.ok(enduranceExerciseService.getEnduranceExerciseById(enduranceExerciseId));
    }

    @GetMapping(value = "/training-sessions/{training_session_id}/endurance-exercises")
    public ResponseEntity<List<EnduranceExerciseDTO>> getAllEnduranceExercisesByTrainingPlanId(
            @PathVariable("training_session_id") Long trainingSessionId) {
        return ResponseEntity.ok(enduranceExerciseService.getAllEnduranceExercisesByTrainingSessionId(trainingSessionId));
    }

    @PostMapping(value = "/training-sessions/{training_session_id}/movements/{movement_id}/endurance-exercises")
    public ResponseEntity<EnduranceExerciseDTO> createEnduranceExercise(
            @RequestBody @Valid EnduranceExerciseDTO dto,
            @PathVariable("training_session_id") Long trainingSessionId,
            @PathVariable("movement_id") Long movementId) {
        return ResponseEntity.ok(enduranceExerciseService.createEnduranceExercise(dto, trainingSessionId, movementId));
    }

    @PatchMapping(value = "/endurance-exercises/{endurance_exercise_id}")
    public ResponseEntity<EnduranceExerciseDTO> updateEnduranceExercise(
            @PathVariable("endurance_exercise_id") Long enduranceExerciseId,
            @RequestBody @Valid EnduranceExerciseDTO dto) {
        return ResponseEntity.ok(enduranceExerciseService.updateEnduranceExercise(enduranceExerciseId, dto));
    }

    @DeleteMapping(value = "/endurance-exercises/{endurance_exercise_id}")
    public ResponseEntity<String> deleteEnduranceExercise(
            @PathVariable("endurance_exercise_id") Long enduranceExerciseId) {
        return ResponseEntity.ok(enduranceExerciseService.deleteEnduranceExercise(enduranceExerciseId));
    }
}
