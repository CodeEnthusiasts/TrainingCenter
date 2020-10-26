package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muscles")
public class MuscleController extends AbstractController<Muscle, MuscleDTO> {

    private final MuscleServiceImpl muscleServiceImpl;

    public MuscleController(MuscleServiceImpl muscleServiceImpl) {
        this.muscleServiceImpl = muscleServiceImpl;
    }

    @Override
    public AbstractService<Muscle, MuscleDTO> getService() {
        return muscleServiceImpl;
    }


/*
    @PostMapping("{id}//images")
    public ResponseEntity<MuscleDTO> addImageToMuscle(@PathVariable Long id, @RequestParam String filePath) {
        return ResponseEntity.ok(muscleServiceImpl.addImageToMuscle(id, filePath));
    }

    @DeleteMapping("{id}/images")
    public ResponseEntity<String> deleteImageFromMuscle(@PathVariable Long id, @RequestParam String fileUrl) {
        muscleServiceImpl.deleteImageFromMuscle(id, fileUrl);
        return ResponseEntity.ok("Image was successfully deleted from muscle");
    }

    @DeleteMapping("{id}/images/delete-all")
    public ResponseEntity<String> deleteAllImagesFromMuscle(@PathVariable Long id) {
        muscleServiceImpl.deleteAllImagesFromMuscle(id);
        return ResponseEntity.ok("All images was successfully deleted from muscle");
    }*/


}
