package codeenthusiast.TrainingCenterApp.trainingsession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/training-sessions")
public class TrainingSessionController {

    private final TrainingSessionServiceImpl trainingSessionService;

    public TrainingSessionController(TrainingSessionServiceImpl trainingSessionService) {
        this.trainingSessionService = trainingSessionService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainingSessionDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(trainingSessionService.getTrainingSessionById(id));
    }

    @GetMapping(value = "/test/{id}")
    public ResponseEntity<TrainingSession> getTestById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(trainingSessionService.getTest(id));
    }

    @GetMapping(value = "/training-plans/{id}")
    public ResponseEntity<List<TrainingSessionDTO>> getAllByTrainingPlanId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(trainingSessionService.getAllTrainingSessionsByTrainingPlanId(id));
    }

    @PostMapping(value = "/training-plans/{training_session_id}")
    public ResponseEntity<TrainingSessionDTO> create(@RequestBody @Valid TrainingSessionDTO dto,
                                                     @PathVariable("training_session_id") Long trainingPlanId) {
        return ResponseEntity.ok(trainingSessionService.createTrainingSession(dto, trainingPlanId));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<TrainingSessionDTO> update(@PathVariable("id") Long id,
                                                     @RequestBody @Valid TrainingSessionDTO dto) {
        return ResponseEntity.ok(trainingSessionService.updateTrainingSession(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(trainingSessionService.deleteTrainingSession(id));
    }

}
