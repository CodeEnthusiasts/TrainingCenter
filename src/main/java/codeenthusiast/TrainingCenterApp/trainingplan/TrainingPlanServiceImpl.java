package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import codeenthusiast.TrainingCenterApp.user.major.UserServiceImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Transient;
import java.util.List;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

    private final TrainingPlanRepository repository;

    private final TrainingPlanMapper mapper;

    private final UserServiceImpl userService;

    public TrainingPlanServiceImpl(TrainingPlanRepository repository, TrainingPlanMapper mapper, UserServiceImpl userService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userService = userService;
    }

    public TrainingPlan getTrainingPlanEntityById(Long id) {
        TrainingPlan trainingPlan =  getNotNullTrainingPlanByIdFromRepo(id);
        if(!hasAccess(trainingPlan)){
            throw new AccessDeniedException("Access denied");
        }
        return trainingPlan;
    }

    @Override
    public TrainingPlanDTO createTrainingPlan(Long userId, TrainingPlanDTO trainingPlanDTO) {
        if(!getPrincipal().getId().equals(userId)){
            throw new AccessDeniedException("Access denied");
        }
        TrainingPlan trainingPlan = mapper.mapToEntity(trainingPlanDTO);
        trainingPlan.setUser(userService.findEntityById(userId));
        return mapper.mapToDTO(save(trainingPlan));
    }

    @Override
    public TrainingPlanDTO updateTrainingPlan(Long trainingPlanId, TrainingPlanDTO trainingPlanDTO) {
        TrainingPlan trainingPlan = getTrainingPlanEntityById(trainingPlanId);
        updateTrainingPlan(trainingPlan, trainingPlanDTO);
        return mapper.mapToDTO(save(trainingPlan));
    }

    @Override
    public List<TrainingPlanDTO> getAllTrainingPlansByUserId(Long userId) {
        if(!getPrincipal().getId().equals(userId)){
            throw new AccessDeniedException("Access denied");
        }
        return mapper.mapToDTOs(repository.findAllByUserId(userId));
    }

    @Override
    public TrainingPlanDTO getTrainingPlanById(Long id) {
        return mapper.mapToDTO(getTrainingPlanEntityById(id));
    }

    @Override
    public String deleteTrainingPlan(Long id) {
        TrainingPlan trainingPlan = getNotNullTrainingPlanByIdFromRepo(id);
        if(!hasAccess(trainingPlan))
            throw new AccessDeniedException("Access denied");
        deleteById(id);
        return "Training plan deleted successfully. ";
    }

    public boolean hasAccess(TrainingPlan trainingPLan) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        if(trainingPLan.getUser().getId().equals(userDetailsImpl.getId()))
            return true;
        else
            return false;
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }

    private TrainingPlan save(TrainingPlan trainingPlan) {
        return repository.save(trainingPlan);
    }

    private TrainingPlan getNotNullTrainingPlanByIdFromRepo(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
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

    @Transient
    private void deleteById(Long id) {
        repository.deleteById(id);
    }

}
