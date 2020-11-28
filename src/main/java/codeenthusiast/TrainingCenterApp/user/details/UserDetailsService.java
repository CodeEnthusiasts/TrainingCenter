package codeenthusiast.TrainingCenterApp.user.details;

public interface UserDetailsService {

    UserDetails saveUserDetails(UserDetails userDetails);

    UserDetailsDTO getUserDetailsByUserId(long userId);

    UserDetailsDTO updateUserDetails(long userDetailsId, UserDetailsDTO dto);
}
