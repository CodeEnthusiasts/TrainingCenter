package codeenthusiast.TrainingCenterApp.user.details;

public interface UserDetailsService {

    UserDetailsDTO findByUserId(Long id);

    UserDetailsDTO update(Long id, UserDetailsDTO dto);
}
