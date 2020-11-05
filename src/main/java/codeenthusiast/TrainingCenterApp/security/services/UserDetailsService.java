package codeenthusiast.TrainingCenterApp.security.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    UserDetails loadByUserName(String username);
}
