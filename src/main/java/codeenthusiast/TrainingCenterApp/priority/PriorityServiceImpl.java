package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService, SecurityService {

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
    public Priority findEntityById(Long id) {
        Priority priority = priorityRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        authorize(hasAccess(priority));
        return priority;
    }

    @Override
    public PriorityDTO findById(Long id) {
        Priority priority = findEntityById(id);
        return priorityMapper.mapToDTO(priority);
    }

    @Override
    public List<PriorityDTO> getAllByTrainingPlanId(Long trainingPlanId) {
        trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        List<Priority> priorityList = priorityRepository.findAllByTrainingPlanId(trainingPlanId);
        return priorityMapper.mapToDTOs(priorityList);
    }

    @Override
    @Transactional
    public PriorityDTO update(Long id, PriorityDTO dto) {
        Priority priority = findEntityById(id);
        updateData(priority, dto);
        return priorityMapper.mapToDTO(priority);
    }

    @Override
    public void updateData(Priority priority, PriorityDTO dto) {
        priority.setName(dto.getName());
        priority.setDetails(dto.getDetails());
    }

    @Override
    @Transactional
    public PriorityDTO create(Long id, PriorityDTO dto) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(id);
        Priority priority = new Priority(dto);
        priority.setTrainingPlan(trainingPlan);
        return save(priority);
    }

    @Override
    public PriorityDTO save(Priority priority) {
        Priority savedPriority = priorityRepository.save(priority);
        return priorityMapper.mapToDTO(savedPriority);
    }

    @Override
    public void deleteById(Long id) {
        priorityRepository.deleteById(id);
    }

    private boolean hasAccess(Priority priority) {
        return priority.getTrainingPlan().getUser().getId().equals(getPrincipal().getId());
    }


}
