package codeenthusiast.TrainingCenterApp.trainingsession;

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
    public TrainingSessionDTO getById(@PathVariable("id") Long id) {
        return trainingSessionService.findById(id);
    }

    @GetMapping(value = "training-plan/{id}")
    public List<TrainingSessionDTO> getAllByTrainingPlanId(@PathVariable("id") Long id) {
        return trainingSessionService.getAllByTrainingPlanId(id);
    }


    @PostMapping(value = "/training-plan/{training_session_id}")
    public TrainingSessionDTO create(@RequestBody @Valid TrainingSessionDTO dto
            , @PathVariable("training_session_id") Long trainingPlanId) {
        return trainingSessionService.create(dto, trainingPlanId);
    }

    @PatchMapping(value = "/{id}")
    public TrainingSessionDTO update(@PathVariable("id") Long id, @RequestBody @Valid TrainingSessionDTO dto) {
        return trainingSessionService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        trainingSessionService.deleteById(id);
    }

}
