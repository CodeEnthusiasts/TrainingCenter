package codeenthusiast.TrainingCenterApp.controllers;

import codeenthusiast.TrainingCenterApp.dto.MuscleDTO;
import codeenthusiast.TrainingCenterApp.services.MuscleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/muscles")
public class MuscleController {

    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MuscleDTO>> getAllMuscles() {
        return ResponseEntity.ok(muscleService.getAllMuscles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuscleDTO> getMuscle(@PathVariable Long id) {
        return ResponseEntity.ok(muscleService.getMuscle(id));
    }

    @PostMapping("/add")
    public ResponseEntity<MuscleDTO> createMuscle(@Valid @RequestBody MuscleDTO muscleDTO) {
        return ResponseEntity.ok(muscleService.createMuscle(muscleDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MuscleDTO> updateMuscle(@PathVariable Long id, @Valid @RequestBody MuscleDTO muscleDTO) {
        return ResponseEntity.ok(muscleService.updateMuscle(id, muscleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMuscle(@PathVariable Long id) {
        muscleService.deleteMuscle(id);
        return ResponseEntity.ok("Muscle was successfully removed from repository");
    }

    @PostMapping("{id}//images")
    public ResponseEntity<MuscleDTO> addImageToMuscle(@PathVariable Long id, @RequestParam String filePath) {
        return ResponseEntity.ok(muscleService.addImageToMuscle(id, filePath));
    }

    @DeleteMapping("{id}/images")
    public ResponseEntity<String> deleteImageFromMuscle(@PathVariable Long id, @RequestParam String fileUrl) {
        muscleService.deleteImageFromMuscle(id, fileUrl);
        return ResponseEntity.ok("Image was successfully deleted from muscle");
    }

    @DeleteMapping("{id}/images/delete-all")
    public ResponseEntity<String> deleteAllImagesFromMuscle(@PathVariable Long id) {
        muscleService.deleteAllImagesFromMuscle(id);
        return ResponseEntity.ok("All images was successfully deleted from muscle");
    }


}
