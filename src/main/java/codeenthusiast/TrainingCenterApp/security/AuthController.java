package codeenthusiast.TrainingCenterApp.security;

import codeenthusiast.TrainingCenterApp.security.request.LoginRequest;
import codeenthusiast.TrainingCenterApp.security.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("sign-in")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("sign-up")
    public ResponseEntity<String> register(@RequestBody @Valid SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.register(signUpRequest));
    }

}
