package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseServiceImpl;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class StrengthExerciseDetailsServiceImpl implements StrengthExerciseDetailsService {

    private final StrengthExerciseDetailsRepository repository;

    private final StrengthExerciseDetailsMapper mapper;

    private final StrengthExerciseServiceImpl strengthExerciseService;

    public StrengthExerciseDetailsServiceImpl(StrengthExerciseDetailsRepository repository,
                                              StrengthExerciseDetailsMapper mapper,
                                              StrengthExerciseServiceImpl strengthExerciseService) {
        this.repository = repository;
        this.mapper = mapper;
        this.strengthExerciseService = strengthExerciseService;
    }

    @Override
    public StrengthExerciseDetailsDTO getStrengthExerciseDetailsById(Long id) {
        StrengthExerciseDetails details = getStrengthExerciseDetailsByIdFromRepo(id);
        if (!hasAccess(details)) {
            throw new AccessDeniedException("Access denied");
        }
        return mapper.mapToDTO(details);
    }

    @Override
    public StrengthExerciseDetailsDTO createStrengthExerciseDetails(Long id, StrengthExerciseDetailsDTO strengthExerciseDetailsDTO) {
        StrengthExercise strengthExercise = strengthExerciseService.getStrengthExerciseById(id);
        if (!strengthExerciseService.hasAccess(strengthExercise)) {
            throw new AccessDeniedException("Access denied");
        }
        StrengthExerciseDetails strengthExerciseDetails = mapper.mapToEntity(strengthExerciseDetailsDTO);
        strengthExerciseDetails.setStrengthExercise(strengthExercise);
        return mapper.mapToDTO(save(strengthExerciseDetails));
    }

    @Override
    public StrengthExerciseDetailsDTO updateStrengthExerciseDetails(Long id, StrengthExerciseDetailsDTO strengthExerciseDetailsDTO) {
        StrengthExerciseDetails strengthExerciseDetails = getStrengthExerciseDetailsByIdFromRepo(id);
        if (!hasAccess(strengthExerciseDetails)) {
            throw new AccessDeniedException("Access denied");
        }
        updateStrengthExerciseDetails(strengthExerciseDetailsDTO, strengthExerciseDetails);
        return mapper.mapToDTO(save(strengthExerciseDetails));
    }

    private StrengthExerciseDetails save(StrengthExerciseDetails strengthExerciseDetails) {
        return repository.save(strengthExerciseDetails);
    }

    private void updateStrengthExerciseDetails(StrengthExerciseDetailsDTO strengthExerciseDetailsDTO, StrengthExerciseDetails strengthExerciseDetails) {
        strengthExerciseDetails.setNote(strengthExerciseDetailsDTO.getNote());
        strengthExerciseDetails.setHoldingDown(strengthExerciseDetailsDTO.getHoldingDown());
        strengthExerciseDetails.setHoldingUp(strengthExerciseDetailsDTO.getHoldingUp());
        strengthExerciseDetails.setLowering(strengthExerciseDetailsDTO.getLowering());
        strengthExerciseDetails.setRaising(strengthExerciseDetailsDTO.getRaising());
    }

    private StrengthExerciseDetails getStrengthExerciseDetailsByIdFromRepo(long id) {
        return repository.findById(id);
    }

    private boolean hasAccess(StrengthExerciseDetails StrengthExerciseDetails) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return StrengthExerciseDetails.getStrengthExercise().getTrainingSession()
                .getTrainingPlan().getUser().getId().equals(userDetailsImpl.getId());
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }

}
