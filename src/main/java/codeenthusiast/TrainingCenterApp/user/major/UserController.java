package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
@PreAuthorize("authentication.principal.id == #userId")
public class UserController {

    private final UserServiceImpl userService;

    private final ImageServiceImpl imageServiceImpl;

    public UserController(UserServiceImpl userService, ImageServiceImpl imageServiceImpl) {
        this.userService = userService;
        this.imageServiceImpl = imageServiceImpl;
    }

    @GetMapping(value = "/{user_id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    // this endpoint need to be fixed - make detached endpoints
    // for updating user's username, email, password and details
    @PatchMapping(value = "/{user_id}")
    public ResponseEntity<UserDTO> update(@PathVariable("user_id") Long userId,
                                 @RequestBody @Valid UserDTO dto) {
        return ResponseEntity.ok(userService.update(userId, dto));
    }

    @PostMapping("/{user_id}/image")
    public ResponseEntity<String> addImage(@PathVariable("user_id") Long userId, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(userService.addImage(userId, file));
    }

    @DeleteMapping("/{user_id}/image")
    public ResponseEntity<String> removeImage(@PathVariable("user_id") Long userId) {
        userService.removeImage(userId);
        return ResponseEntity.ok("Image was successfully removed.");
    }

}
