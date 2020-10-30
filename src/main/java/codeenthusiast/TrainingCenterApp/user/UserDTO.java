package codeenthusiast.TrainingCenterApp.user;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractDTO {

    private String username;

    private String email;

    private UserDetailsDTO userDetailsDto;

    private String imageUrl;

    public UserDTO(String username, String email, UserDetailsDTO userDetailsDto, String imageUrl) {
        this.username = username;
        this.email = email;
        this.userDetailsDto = userDetailsDto;
        this.imageUrl = imageUrl;
    }
}
