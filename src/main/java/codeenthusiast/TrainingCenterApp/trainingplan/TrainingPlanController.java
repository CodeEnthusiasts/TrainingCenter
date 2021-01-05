package codeenthusiast.TrainingCenterApp.trainingplan;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("/api")
public class TrainingPlanController {

    private final TrainingPlanService trainingPlanService;

    public TrainingPlanController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @PreAuthorize("authentication.principal.id == #userId")
    @GetMapping(value = "/users/{user_id}/training-plans/all")
    public ResponseEntity<List<TrainingPlanDTO>> getTrainingPlans(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(trainingPlanService.getAllTrainingPlansByUserId(userId));
    }

    @GetMapping(value = "/training-plans/{training_plan_id}")
    public ResponseEntity<TrainingPlanDTO> getTrainingPlan(@PathVariable("training_plan_id") Long id) {
        return ResponseEntity.ok(trainingPlanService.getTrainingPlanById(id));
    }

    @PreAuthorize("authentication.principal.id == #userId")
    @PostMapping(value = "/users/{user_id}/training-plans")
    public ResponseEntity<TrainingPlanDTO> createTrainingPlan(@PathVariable("user_id") Long userId,
                                                              @RequestBody @Valid TrainingPlanDTO dto) {
        return ResponseEntity.ok(trainingPlanService.createTrainingPlan(userId, dto));
    }

    @PatchMapping(value = "/training-plans/{training_plan_id}")
    public ResponseEntity<TrainingPlanDTO> updateTrainingPlan(@PathVariable("training_plan_id") Long id,
                                                              @RequestBody @Valid TrainingPlanDTO dto) {
        return ResponseEntity.ok(trainingPlanService.updateTrainingPlan(id, dto));
    }

    @DeleteMapping(value = "/training-plans/{training_plan_id}")
    public ResponseEntity<String> deleteTrainingPLan(@PathVariable("training_plan_id") Long id) {
        return ResponseEntity.ok(trainingPlanService.deleteTrainingPlan(id));
    }
}
