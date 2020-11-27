package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.mappers.PriorityMapper;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanServiceImpl;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    private final TrainingPlanServiceImpl trainingPlanService;

    private final PriorityMapper priorityMapper;


    public PriorityServiceImpl(PriorityRepository priorityRepository,
                               TrainingPlanServiceImpl trainingPlanService, PriorityMapper priorityMapper) {
        this.priorityRepository = priorityRepository;
        this.trainingPlanService = trainingPlanService;
        this.priorityMapper = priorityMapper;
    }


    @Override
    public void deleteById(Long id) {
        priorityRepository.deleteById(id);
    }

    @Override
    public List<PriorityDTO> getAllByTrainingPlanId(Long id) {
        return priorityMapper.mapToDTOs(priorityRepository.findAllByTrainingPlanId(id));
    }

    @Override
    public PriorityDTO findById(Long id) {
        Priority priority = priorityRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(id));
        return priorityMapper.mapToDTO(priority);
    }

    @Override
    public PriorityDTO update(Long id, PriorityDTO dto) {
        dto.setId(id);
        return save(dto);
    }

    @Override
    public PriorityDTO create(Long id, PriorityDTO dto) {
        TrainingPlan trainingPlan = trainingPlanService.findEntityById(id);
        Priority priority = priorityMapper.mapToEntity(dto);

        priority.setTrainingPlan(trainingPlan);
        return save(priorityMapper.mapToDTO(priority));
    }

    @Override
    public PriorityDTO save(PriorityDTO dto) {
        Priority priority = priorityMapper.mapToEntity(dto);
        priorityRepository.save(priority);
        return dto;
    }
}
