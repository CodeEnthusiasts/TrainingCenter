package codeenthusiast.TrainingCenterApp.user.details;

public interface UserDetailsService {

    UserDetailsDTO findByUserId(long id);

    UserDetailsDTO updateUserDetails(long id, UserDetailsDTO dto);
}
