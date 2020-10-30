package codeenthusiast.TrainingCenterApp.user.major;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.user.details.UserDetails;
import codeenthusiast.TrainingCenterApp.user.details.UserDetailsDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractDTO {

    private String username;

    private String email;

    private UserDetailsDTO userDetailsDTO;

    private String imageUrl;

    public UserDTO(String username, String email, UserDetailsDTO userDetailsDTO, String imageUrl) {
        this.username = username;
        this.email = email;
        this.userDetailsDTO = userDetailsDTO;
        this.imageUrl = imageUrl;
    }
}
