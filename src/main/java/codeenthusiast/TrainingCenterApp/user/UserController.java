package codeenthusiast.TrainingCenterApp.user;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.user.major.User;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User, UserDTO> {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public AbstractService<User, UserDTO> getService() {
        return userServiceImpl;
    }

    @PostMapping("/add-image")
    public ResponseEntity<UserDTO> addImage(@PathVariable("id") Long id, @RequestBody ImageDTO image) {
        return ResponseEntity.ok(userServiceImpl.addImage(id, image));
    }

    @DeleteMapping("/remove-image")
    public ResponseEntity<String> removeImage(@PathVariable("id") Long id) {
        userServiceImpl.removeImage(id);
        return ResponseEntity.ok("Image was successfully removed.");
    }

}
