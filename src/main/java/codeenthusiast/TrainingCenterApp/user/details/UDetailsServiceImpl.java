package codeenthusiast.TrainingCenterApp.user.details;

import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository repository;

    private final UserDetailsMapper mapper;

    public UDetailsServiceImpl(UserDetailsRepository repository, UserDetailsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
        return save(userDetails);
    }

    @Override
    public UserDetailsDTO getUserDetailsByUserId(long userId) {
        return mapToDTO(repository.findByUserId(userId));
    }

    @Override
    public UserDetailsDTO updateUserDetails(long id, UserDetailsDTO dto) {
        UserDetails userDetails = getUserDetailsByIdFromRepo(id);
        if(!hasAccess(userDetails)) {
            throw new AccessDeniedException("Access denied");
        }
        updateUserDetailsAttributes(dto, userDetails);
        return mapToDTO(save(userDetails));
    }

    private boolean hasAccess(UserDetails userDetails) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        if(userDetails.getUser().getId().equals(userDetailsImpl.getId()))
            return true;
        else
            return false;
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }

    private UserDetails getUserDetailsByIdFromRepo(long id) {
        return repository.findById(id);
    }

    private UserDetails save(UserDetails userDetails) {
        return repository.save(userDetails);
    }

    private void updateUserDetailsAttributes(UserDetailsDTO dto, UserDetails userDetails) {
        userDetails.setAge(dto.getAge());
        userDetails.setBodyWeightUnit(dto.getBodyWeightUnit());
        userDetails.setWeight(dto.getWeight());
        userDetails.setHeightUnit(dto.getHeightUnit());
        userDetails.setHeight(dto.getHeight());
        userDetails.setSex(dto.getSex());
    }

    private UserDetailsDTO mapToDTO(UserDetails userDetails) {
        return mapper.mapToDTO(userDetails);
    }
}
