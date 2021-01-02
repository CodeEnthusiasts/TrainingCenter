package codeenthusiast.TrainingCenterApp.user.details;

 import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

@Service
public class UDetailsServiceImpl implements UserDetailsService, SecurityService {

    private final UserDetailsRepository repository;

    private final UserDetailsMapper mapper;

    public UDetailsServiceImpl(UserDetailsRepository repository, UserDetailsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails getUserDetailsEntityById(Long id) {
        UserDetails userDetails = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(userDetails));
        return userDetails;
    }

    @Override
    public UserDetailsDTO getUserDetailsByUserId(long userId) {
        UserDetails userDetails = repository.findByUserId(userId).orElseThrow(EntityNotFoundException::new);
        return mapToDTO(userDetails);
    }

    @Override
    @Transactional
    public UserDetailsDTO updateUserDetails(long id, UserDetailsDTO dto) {
        UserDetails userDetails = getUserDetailsEntityById(id);
        updateUserDetailsAttributes(dto, userDetails);
        return mapToDTO(userDetails);
    }

    private boolean hasAccess(UserDetails userDetails) {
        return userDetails.getUser().getId().equals(getPrincipalId());
    }

    private UserDetails save(UserDetails userDetails) {
        return repository.save(userDetails);
    }

    private void updateUserDetailsAttributes(UserDetailsDTO dto, UserDetails userDetails) {
        userDetails.setAge(dto.getAge());
        if(isNotNull(dto.getBodyWeightUnit()))
            userDetails.setBodyWeightUnit(dto.getBodyWeightUnit());
        userDetails.setWeight(dto.getWeight());
        if(isNotNull(dto.getHeightUnit()))
            userDetails.setHeightUnit(dto.getHeightUnit());
        userDetails.setHeight(dto.getHeight());
        if(isNotNull(dto.getSex()))
            userDetails.setSex(dto.getSex());
    }

    private boolean isNotNull(Object object) {
        return object != null;
    }

    private UserDetailsDTO mapToDTO(UserDetails userDetails) {
        return mapper.mapToDTO(userDetails);
    }
}
