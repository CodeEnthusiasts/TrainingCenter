package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import codeenthusiast.TrainingCenterApp.user.details.UserDetailsDTO;
import codeenthusiast.TrainingCenterApp.user.role.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    private final ImageServiceImpl imageServiceImpl;

    public UserController(UserServiceImpl userService, ImageServiceImpl imageServiceImpl) {
        this.userService = userService;
        this.imageServiceImpl = imageServiceImpl;
    }

    @GetMapping(value = "/{id}")
    public UserDTO getById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PatchMapping(value = "/{id}")
    public UserDTO update(@PathVariable("id") Long id,
                                 @RequestBody @Valid UserDTO dto) {
        return userService.update(id, dto);
    }


    @PostMapping("{id}/image")
    public ResponseEntity<UserDTO> addImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        ImageDTO image = imageServiceImpl.createNewImage(file);
        return ResponseEntity.ok(userService.addImage(id, image));
    }

    @DeleteMapping("{id}/image")
    public ResponseEntity<String> removeImage(@PathVariable("id") Long id) {
        userService.removeImage(id);
        return ResponseEntity.ok("Image was successfully removed.");
    }

}
