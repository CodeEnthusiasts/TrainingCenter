package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/muscles")
public class MuscleController {

    private MuscleService muscleService;

    private final ImageServiceImpl imageServiceImpl;

    public MuscleController(MuscleService muscleService, ImageServiceImpl imageServiceImpl) {
        this.muscleService = muscleService;
        this.imageServiceImpl = imageServiceImpl;
    }

    @GetMapping(value = "/{id}")
    public MuscleDTO getById(@PathVariable("id") Long id) {
        return muscleService.findById(id);
    }

    @PostMapping
    public MuscleDTO create(@RequestBody @Valid MuscleDTO dto){
        return muscleService.create(dto);
    }

    @PutMapping(value = "/{id}")
    public MuscleDTO update(@PathVariable("id") Long id, @RequestBody @Valid MuscleDTO dto){
        return muscleService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id)throws Exception {
        muscleService.deleteById(id);
    }

    @PostMapping("{id}/image")
    public ResponseEntity<MuscleDTO> addImage(@PathVariable("id") Long id, @RequestParam ("file") MultipartFile file) {
        ImageDTO image = imageServiceImpl.createNewImage(file);
        return ResponseEntity.ok(muscleService.addImage(id, image));
    }

    @DeleteMapping("{id}/image/")
    public ResponseEntity<String> removeAllImages(@PathVariable("id") Long id){
        List<Long> idImages = muscleService.removeAllImages(id);
        imageServiceImpl.deleteImagesById(idImages);
        return ResponseEntity.ok("Image was successfully removed.");
    }
}
