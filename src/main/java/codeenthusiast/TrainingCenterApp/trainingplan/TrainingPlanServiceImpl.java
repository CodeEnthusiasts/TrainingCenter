package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.user.major.UserServiceImpl;
import org.springframework.stereotype.Service;

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

    public TrainingPlan getTrainingPlanById(Long id) {
        return getTrainingPlanByIdFromRepo(id);
    }

    @Override
    public TrainingPlanDTO createTrainingPlan(Long userId, TrainingPlanDTO trainingPlanDTO) {
        TrainingPlan trainingPlan = mapToEntity(trainingPlanDTO);
        trainingPlan.setUser(userService.findEntityById(userId));
        return mapToDTO(save(trainingPlan));
    }

    @Override
    public TrainingPlanDTO updateTrainingPlan(Long trainingPlanId, TrainingPlanDTO trainingPlanDTO) {
        TrainingPlan trainingPlan = getTrainingPlanByIdFromRepo(trainingPlanId);
        updateTrainingPlan(trainingPlan, trainingPlanDTO);
        return mapToDTO(save(trainingPlan));
    }

    @Override
    public List<TrainingPlanDTO> getAllTrainingPlansByUserId(Long id) {
        return mapToDTOs(repository.findAllByUserId(id));
    }

    @Override
    public TrainingPlanDTO getTrainingPlanById(long id) {
        return mapToDTO(getTrainingPlanByIdFromRepo(id));
    }

    @Override
    public String deleteTrainingPlan(Long id) {
        deleteById(id);
        return "Training plan deleted successfully. ";
    }


    private TrainingPlan save(TrainingPlan trainingPlan) {
        return repository.save(trainingPlan);
    }

    private TrainingPlan getTrainingPlanByIdFromRepo(long id) {
        return repository.findById(id);
    }

    private void updateTrainingPlan(TrainingPlan trainingPlan, TrainingPlanDTO trainingPlanDTO) {
        trainingPlan.setStartDate(trainingPlanDTO.getStartDate());
        trainingPlan.setEndDate(trainingPlanDTO.getEndDate());
        trainingPlan.setDescription(trainingPlanDTO.getDescription());
        trainingPlan.setDifficulty(trainingPlanDTO.getDifficulty());
    }

    private void deleteById(Long id) {
        repository.deleteById(id);
    }

    private TrainingPlan mapToEntity(TrainingPlanDTO trainingPlanDTO) {
        return mapper.mapToEntity(trainingPlanDTO);
    }

    private TrainingPlanDTO mapToDTO(TrainingPlan trainingPlan) {
        return mapper.mapToDTO(trainingPlan);
    }

    private List<TrainingPlanDTO> mapToDTOs(List<TrainingPlan> list) {
        return mapper.mapToDTOs(list);
    }

}
