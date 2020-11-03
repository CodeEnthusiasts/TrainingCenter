package codeenthusiast.TrainingCenterApp.security.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class SignUpRequest {

    @NotBlank
    @Size(min = 5, max = 32)
    private String username;

    @Email
    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(min = 6, max = 32)
    private String password;

    @NotBlank
    @Size(min = 6, max = 32)
    private String confirmPassword;


}
