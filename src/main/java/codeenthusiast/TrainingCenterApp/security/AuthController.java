package codeenthusiast.TrainingCenterApp.security;

import codeenthusiast.TrainingCenterApp.security.request.LoginRequest;
import codeenthusiast.TrainingCenterApp.security.request.SignUpRequest;
import codeenthusiast.TrainingCenterApp.security.response.JwtResponse;
import codeenthusiast.TrainingCenterApp.security.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/home")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.authenticateUser(loginRequest));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<MessageResponse> register(@RequestBody @Valid SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authService.registerUser(signUpRequest));
    }

}
