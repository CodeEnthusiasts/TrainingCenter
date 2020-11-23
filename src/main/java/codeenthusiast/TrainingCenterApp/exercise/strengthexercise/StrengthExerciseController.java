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
    public List<StrengthExerciseDTO> getAllByTrainingPlanId(@PathVariable("id") Long id){
        return strengthExerciseService.getAllByTrainingSessionId(id);
    }


    @PostMapping
    public StrengthExerciseDTO create(@RequestBody @Valid StrengthExerciseDTO dto, @PathVariable("id") Long id) {
        return strengthExerciseService.create(dto);
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

