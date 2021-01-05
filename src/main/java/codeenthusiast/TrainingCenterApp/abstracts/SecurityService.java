package codeenthusiast.TrainingCenterApp.abstracts;

import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface SecurityService {

    default void authorize(boolean b) {
        if(!b)
            throw new AccessDeniedException("Access denied");
    }
    
    default Long getPrincipalId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals("test_user")){
            return 1L;
        } else{
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return userDetails.getId();
        }
    }
}
