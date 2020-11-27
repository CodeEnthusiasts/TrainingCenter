package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.StrengthExerciseDetailsMapper;
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
        return mapToDTO(getStrengthExerciseDetailsByIdFromRepo(id));
    }

    @Override
    public StrengthExerciseDetailsDTO createStrengthExerciseDetails(Long id, StrengthExerciseDetailsDTO strengthExerciseDetailsDTO) {
        StrengthExerciseDetails strengthExerciseDetails = mapToEntity(strengthExerciseDetailsDTO);
        strengthExerciseDetails.setStrengthExercise(strengthExerciseService.getStrengthExerciseById(id));
        return mapToDTO(save(strengthExerciseDetails));
    }

    @Override
    public StrengthExerciseDetailsDTO updateStrengthExerciseDetails(Long id, StrengthExerciseDetailsDTO strengthExerciseDetailsDTO) {
        StrengthExerciseDetails strengthExerciseDetails = getStrengthExerciseDetailsByIdFromRepo(id);
        updateStrengthExerciseDetails(strengthExerciseDetailsDTO, strengthExerciseDetails);
        return mapToDTO(save(strengthExerciseDetails));
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

    private StrengthExerciseDetails mapToEntity(StrengthExerciseDetailsDTO strengthExerciseDetailsDTO) {
        return mapper.mapToEntity(strengthExerciseDetailsDTO);
    }

    private StrengthExerciseDetailsDTO mapToDTO(StrengthExerciseDetails strengthExerciseDetails) {
        return mapper.mapToDTO(strengthExerciseDetails);
    }

}
