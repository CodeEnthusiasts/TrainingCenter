package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

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
    public ResponseEntity<MuscleDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(muscleServiceImpl.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public ResponseEntity<MuscleDTO> create(@RequestBody @Valid MuscleDTO dto) {
        return ResponseEntity.ok(muscleServiceImpl.create(dto));
    }

    @PatchMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public ResponseEntity<MuscleDTO> update(@PathVariable("id") Long id, @RequestBody @Valid MuscleDTO dto) {
        return ResponseEntity.ok(muscleServiceImpl.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public void delete(@PathVariable("id") Long id) throws Exception {
        muscleServiceImpl.deleteById(id);
    }

    @PostMapping("{id}/image")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public ResponseEntity<MuscleDTO> addImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(muscleServiceImpl.addImage(id, file));
    }

    @DeleteMapping("{id}/image/")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public ResponseEntity<String> removeAllImages(@PathVariable("id") Long id) {
        muscleServiceImpl.removeAllImages(id);
        return ResponseEntity.ok("Image was successfully removed.");
    }
}
