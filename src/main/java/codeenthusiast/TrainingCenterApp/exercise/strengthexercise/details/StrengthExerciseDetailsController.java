package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StrengthExerciseDetailsController {

    private final StrengthExerciseDetailsServiceImpl service;

    public StrengthExerciseDetailsController(StrengthExerciseDetailsServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/strength-exercise-details/{strength_exercise_details_id}")
    public ResponseEntity<StrengthExerciseDetailsDTO> getStrengthExerciseDetails(
            @PathVariable("strength_exercise_details_id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping(value = "/strength-exercise/{strength_exercise_id}")
    public ResponseEntity<StrengthExerciseDetailsDTO> createStrengthExerciseDetails(
            @PathVariable("strength_exercise_id") Long id,
            @RequestBody @Valid StrengthExerciseDetailsDTO dto) {
        return ResponseEntity.ok(service.create(id, dto));
    }

    @PatchMapping(value = "/strength-exercise-details/{strength_exercise_details_id}")
    public ResponseEntity<StrengthExerciseDetailsDTO> updateStrengthExerciseDetails(
            @PathVariable("strength_exercise_details_id") Long id,
            @RequestBody @Valid StrengthExerciseDetailsDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }


}
