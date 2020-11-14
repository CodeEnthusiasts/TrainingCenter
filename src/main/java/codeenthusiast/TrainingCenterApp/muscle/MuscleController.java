package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/muscles")
public class MuscleController {

    private MuscleServiceImpl muscleServiceImpl;

    private final ImageServiceImpl imageServiceImpl;

    public MuscleController(MuscleServiceImpl muscleServiceImpl, ImageServiceImpl imageServiceImpl) {
        this.muscleServiceImpl = muscleServiceImpl;
        this.imageServiceImpl = imageServiceImpl;
    }

    @GetMapping(value = "/{id}")
    public MuscleDTO getById(@PathVariable("id") Long id) {
        return muscleServiceImpl.findById(id);
    }

    @PostMapping
    public MuscleDTO create(@RequestBody @Valid MuscleDTO dto){
        return muscleServiceImpl.create(dto);
    }

    @PatchMapping(value = "/{id}")
    public MuscleDTO update(@PathVariable("id") Long id, @RequestBody @Valid MuscleDTO dto){
        return muscleServiceImpl.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id)throws Exception {
        muscleServiceImpl.deleteById(id);
    }

    @PostMapping("{id}/image")
    public ResponseEntity<MuscleDTO> addImage(@PathVariable("id") Long id, @RequestParam ("file") MultipartFile file) {
        ImageDTO image = imageServiceImpl.createNewImage(file);
        return ResponseEntity.ok(muscleServiceImpl.addImage(id, image));
    }

    @DeleteMapping("{id}/image/")
    public ResponseEntity<String> removeAllImages(@PathVariable("id") Long id){
        List<Long> idImages = muscleServiceImpl.removeAllImages(id);
        imageServiceImpl.deleteImagesById(idImages);
        return ResponseEntity.ok("Image was successfully removed.");
    }
}
