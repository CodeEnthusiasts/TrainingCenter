package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.user.major.UserServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Transient;
import java.util.List;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService, SecurityService {

    private final TrainingPlanRepository repository;

    private final TrainingPlanMapper mapper;

    private final UserServiceImpl userService;

    public TrainingPlanServiceImpl(TrainingPlanRepository repository, TrainingPlanMapper mapper, UserServiceImpl userService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public TrainingPlan getTrainingPlanEntityById(Long id) {
        TrainingPlan trainingPlan = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(trainingPlan));
        return trainingPlan;
    }

    @Override
    public TrainingPlanDTO getTrainingPlanById(Long id) {
        return mapToDTO(getTrainingPlanEntityById(id));
    }

    @Override
    @Transactional
    public TrainingPlanDTO createTrainingPlan(Long userId, TrainingPlanDTO trainingPlanDTO) {
        TrainingPlan trainingPlan = mapper.mapToEntity(trainingPlanDTO);
        trainingPlan.setUser(userService.findEntityById(userId));
        return mapToDTO(save(trainingPlan));
    }

    @Override
    @Transactional
    public TrainingPlanDTO updateTrainingPlan(Long trainingPlanId, TrainingPlanDTO trainingPlanDTO) {
        TrainingPlan trainingPlan = getTrainingPlanEntityById(trainingPlanId);
        updateTrainingPlan(trainingPlan, trainingPlanDTO);
        return mapToDTO(save(trainingPlan));
    }

    @Override
    public List<TrainingPlanDTO> getAllTrainingPlansByUserId(Long userId) {
        return mapToDTOs(repository.findAllByUserId(userId));
    }

    @Transient
    @Override
    public String deleteTrainingPlan(Long id) {
        repository.delete(getTrainingPlanEntityById(id));
        return "Training plan deleted successfully. ";
    }

    private boolean hasAccess(TrainingPlan trainingPLan) {
        return trainingPLan.getUser().getId().equals(getPrincipal().getId());
    }

    private TrainingPlan save(TrainingPlan trainingPlan) {
        return repository.save(trainingPlan);
    }

    private void updateTrainingPlan(TrainingPlan trainingPlan, TrainingPlanDTO trainingPlanDTO) {
        trainingPlan.setName(trainingPlanDTO.getName());
        trainingPlan.setStartDate(trainingPlanDTO.getStartDate());
        trainingPlan.setEndDate(trainingPlanDTO.getEndDate());
        trainingPlan.setDescription(trainingPlanDTO.getDescription());
        trainingPlan.setDifficulty(trainingPlanDTO.getDifficulty());
        trainingPlan.setNumberOfPlannedTrainings(trainingPlanDTO.getNumberOfPlannedTrainings());
        trainingPlan.setNumberOfExecutedTrainings(trainingPlanDTO.getNumberOfExecutedTrainings());
    }

    private List<TrainingPlanDTO> mapToDTOs(List<TrainingPlan> list) {
        return mapper.mapToDTOs(list);
    }

    private TrainingPlanDTO mapToDTO(TrainingPlan trainingPlan) {
        return mapper.mapToDTO(trainingPlan);
    }

}
