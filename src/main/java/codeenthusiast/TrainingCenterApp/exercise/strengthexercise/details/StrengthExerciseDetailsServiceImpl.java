package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StrengthExerciseDetailsServiceImpl implements StrengthExerciseDetailsService, SecurityService {

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

    public StrengthExerciseDetails getEntityById(Long id) {
        StrengthExerciseDetails details = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        authorize(hasAccess(details));
        return details;
    }

    public StrengthExerciseDetailsDTO getById(Long id) {
        StrengthExerciseDetails details = getEntityById(id);
        return mapper.mapToDTO(details);
    }

    @Override
    @Transactional
    public StrengthExerciseDetailsDTO create(Long id, StrengthExerciseDetailsDTO strengthExerciseDetailsDTO) {
        StrengthExercise strengthExercise = strengthExerciseService.getStrengthExerciseById(id);

        StrengthExerciseDetails strengthExerciseDetails = mapper.mapToEntity(strengthExerciseDetailsDTO);

        strengthExerciseDetails.setStrengthExercise(strengthExercise);

        return save(strengthExerciseDetails);
    }

    @Override
    @Transactional
    public StrengthExerciseDetailsDTO update(Long id, StrengthExerciseDetailsDTO strengthExerciseDetailsDTO) {
        StrengthExerciseDetails strengthExerciseDetails = getEntityById(id);
        updateData(strengthExerciseDetailsDTO, strengthExerciseDetails);
        return mapper.mapToDTO(strengthExerciseDetails);
    }

    private StrengthExerciseDetailsDTO save(StrengthExerciseDetails strengthExerciseDetails) {
        StrengthExerciseDetails savedDetails = repository.save(strengthExerciseDetails);
        return mapper.mapToDTO(savedDetails);
    }

    private void updateData(StrengthExerciseDetailsDTO strengthExerciseDetailsDTO, StrengthExerciseDetails strengthExerciseDetails) {
        strengthExerciseDetails.setNote(strengthExerciseDetailsDTO.getNote());
        strengthExerciseDetails.setHoldingDown(strengthExerciseDetailsDTO.getHoldingDown());
        strengthExerciseDetails.setHoldingUp(strengthExerciseDetailsDTO.getHoldingUp());
        strengthExerciseDetails.setLowering(strengthExerciseDetailsDTO.getLowering());
        strengthExerciseDetails.setRaising(strengthExerciseDetailsDTO.getRaising());
    }

    private boolean hasAccess(StrengthExerciseDetails StrengthExerciseDetails) {
        return StrengthExerciseDetails.getStrengthExercise().getTrainingSession()
                .getTrainingPlan().getUser().getId().equals(getPrincipal().getId());
    }


}
