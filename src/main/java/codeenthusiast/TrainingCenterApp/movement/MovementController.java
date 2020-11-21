package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/movements")
public class MovementController {

    private final MovementServiceImpl movementService;

    private final ImageServiceImpl imageService;

    public MovementController(MovementServiceImpl movementService, ImageServiceImpl imageService) {
        this.movementService = movementService;
        this.imageService = imageService;
    }

    @GetMapping(value = "/{id}")
    public MovementDTO getById(@PathVariable("id") Long id) {
        return movementService.findById(id);
    }

    @PostMapping
    public MovementDTO create(@RequestBody @Valid MovementDTO dto) {
        return movementService.create(dto);
    }

    @PatchMapping(value = "/{id}")
    public MovementDTO update(@PathVariable("id") Long id, @RequestBody @Valid MovementDTO dto) {
        return movementService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        movementService.deleteById(id);
    }

    @PostMapping("{id}/image")
    public ResponseEntity<MovementDTO> addImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        ImageDTO image = imageService.createNewImage(file);
        return ResponseEntity.ok(movementService.addImage(id, image));
    }

    @DeleteMapping("{id}/image/")
    public ResponseEntity<String> removeAllImages(@PathVariable("id") Long id) {
        List<Long> idImages = movementService.removeAllImages(id);
        imageService.deleteImagesById(idImages);
        return ResponseEntity.ok("Image was successfully removed.");
    }

}
