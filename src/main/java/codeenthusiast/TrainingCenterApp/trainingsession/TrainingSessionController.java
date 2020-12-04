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
        return ResponseEntity.ok(trainingSessionService.findById(id));
    }

    @GetMapping(value = "training-plan/{id}")
    public ResponseEntity<List<TrainingSessionDTO>> getAllByTrainingPlanId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(trainingSessionService.getAllByTrainingPlanId(id));
    }


    @PostMapping(value = "/training-plan/{training_session_id}")
    public ResponseEntity<TrainingSessionDTO> create(@RequestBody @Valid TrainingSessionDTO dto
            , @PathVariable("training_session_id") Long trainingPlanId) {
        return ResponseEntity.ok(trainingSessionService.create(dto, trainingPlanId));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<TrainingSessionDTO> update(@PathVariable("id") Long id, @RequestBody @Valid TrainingSessionDTO dto) {
        return ResponseEntity.ok(trainingSessionService.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        trainingSessionService.deleteById(id);
    }

}
