package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanServiceImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public List<PriorityDTO> getAllByTrainingPlanId(Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        if(!trainingPlanService.hasAccess(trainingPlan)){
            throw  new AccessDeniedException("Access denied");
        }
        return priorityMapper.mapToDTOs(priorityRepository.findAllByTrainingPlanId(trainingPlanId));
    }

    public Priority findEntityById(Long id){
        Priority priority =  priorityRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        if(!hasAccess(priority)){
            throw new AccessDeniedException("Access denied");
        }
        return priority;
    }
    @Override
    public PriorityDTO findById(Long id) {
        Priority priority = priorityRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(id));
        if(!hasAccess(priority)){
            throw new AccessDeniedException("Access denied");
        }
        return priorityMapper.mapToDTO(priority);
    }

    @Override
    public PriorityDTO update(Long id, PriorityDTO dto) {
        Priority priority =  findEntityById(id);
        priority.setName(dto.getName());
        priority.setDetails(dto.getDetails());
        return save(priority);
    }

    @Override
    public PriorityDTO create(Long id, PriorityDTO dto) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(id);
        if(!trainingPlanService.hasAccess(trainingPlan)){
            throw  new AccessDeniedException("Access denied");
        }
        Priority priority = new Priority(dto);

        priority.setTrainingPlan(trainingPlan);
        return save(priority);
    }

    @Override
    public PriorityDTO save(PriorityDTO dto) {
        Priority priority = priorityMapper.mapToEntity(dto);
        priorityRepository.save(priority);
        return dto;
    }

    public PriorityDTO save(Priority priority) {

        return priorityMapper.mapToDTO(priorityRepository.save(priority));
    }

    public boolean hasAccess(Priority priority) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return priority.getTrainingPlan().getUser().getId().equals(userDetailsImpl.getId());
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }
}
