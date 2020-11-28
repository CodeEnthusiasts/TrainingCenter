package codeenthusiast.TrainingCenterApp.user.details;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UDetailsServiceImpl implements UserDetailsService {

    private UserDetailsRepository userDetailsRepository;

    private UserDetailsMapper userDetailsMapper;

    public UDetailsServiceImpl(UserDetailsRepository userDetailsRepository, UserDetailsMapper userDetailsMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public UserDetailsDTO findByUserId(Long id) {
        return userDetailsRepository.findByUserId(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    @Override
    public UserDetailsDTO update(Long id, UserDetailsDTO dto) {
        dto.setId(id);
        return save(dto);
    }

    public UserDetailsDTO save(UserDetailsDTO dto) {
        UserDetails details = userDetailsMapper.mapToEntity(dto);
        userDetailsRepository.save(details);
        return dto;
    }
}
