package codeenthusiast.TrainingCenterApp.security;

import codeenthusiast.TrainingCenterApp.security.request.LoginRequest;
import codeenthusiast.TrainingCenterApp.security.request.SignUpRequest;
import codeenthusiast.TrainingCenterApp.user.User;
import codeenthusiast.TrainingCenterApp.user.UserDetails;
import codeenthusiast.TrainingCenterApp.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    UserService userService;


    public String login(LoginRequest loginRequest) {
        if (userService.existsByUsernameAndPassword(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()) ||
                userService.existsByEmailAndPassword(loginRequest.getUsernameOrEmail(), loginRequest.getPassword())) {
            return "Logged correctly";
        } else {
            return "Combination of credentials is wrong";
        }
    }

    public String register(SignUpRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getEmail()) || userService.existsByEmail(signUpRequest.getUsername())) {
            return "This user currently exists in database";
        } else if (signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
            User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword(), signUpRequest.getEmail(),
                    new UserDetails());
            userService.saveEntity(user);
            return "Your account has successfully been created!";
        } else {
            return "Password are not the match";
        }
    }
}
