package codeenthusiast.TrainingCenterApp.user.details;

public interface UserDetailsService {

    UserDetails getUserDetailsEntityById(Long id);

    UserDetailsDTO getUserDetailsByUserId(long userId);

    UserDetailsDTO updateUserDetails(long userDetailsId, UserDetailsDTO dto);
}
