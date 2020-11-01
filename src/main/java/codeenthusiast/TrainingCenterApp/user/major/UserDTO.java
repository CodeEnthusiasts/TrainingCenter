package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.user.details.UserDetailsDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractDTO {

    @NotBlank
    @Size(min = 5, max = 30)
    private String username;

    private String email;

    @Valid
    private UserDetailsDTO userDetailsDTO;

    private String imageUrl;

    public UserDTO(String username, String email, UserDetailsDTO userDetailsDTO, String imageUrl) {
        this.username = username;
        this.email = email;
        this.userDetailsDTO = userDetailsDTO;
        this.imageUrl = imageUrl;
    }
}
