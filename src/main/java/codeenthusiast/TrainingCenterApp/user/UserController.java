package codeenthusiast.TrainingCenterApp.user;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
import codeenthusiast.TrainingCenterApp.user.major.User;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User, UserDTO> {

    private final UserServiceImpl userServiceImpl;

    private final ImageServiceImpl imageServiceImpl;

    public UserController(UserServiceImpl userServiceImpl, ImageServiceImpl imageServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.imageServiceImpl = imageServiceImpl;
    }

    @Override
    public AbstractService<User, UserDTO> getService() {
        return userServiceImpl;
    }

    @PostMapping("{id}/image")
    public ResponseEntity<UserDTO> addImage(@PathVariable("id") Long id, @RequestParam ("file") MultipartFile file) {
        ImageDTO image = imageServiceImpl.createNewImage(file);
        return ResponseEntity.ok(userServiceImpl.addImage(id, image));
    }

    @DeleteMapping("{id}/image")
    public ResponseEntity<String> removeImage(@PathVariable("id") Long id) {
        userServiceImpl.removeImage(id);
        return ResponseEntity.ok("Image was successfully removed.");
    }

}
