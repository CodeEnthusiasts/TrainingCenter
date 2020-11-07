package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.PriorityMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class PriorityServiceImpl extends AbstractServiceImpl<Priority, PriorityDTO>
        implements PriorityService{

    private PriorityRepository priorityRepository;

    private PriorityMapper priorityMapper;

    public PriorityServiceImpl(AbstractRepository<Priority> repository, AbstractMapper<Priority,
            PriorityDTO> mapper, PriorityRepository priorityRepository, PriorityMapper priorityMapper) {
        super(repository, mapper);
        this.priorityRepository = priorityRepository;
        this.priorityMapper = priorityMapper;
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        PriorityDTO p1 = new PriorityDTO("Grow chest", "Train chest 3 x per week");
//        PriorityDTO p2 = new PriorityDTO("Improve work tolerance", "Train with big volume");
//        PriorityDTO p3 = new PriorityDTO("Heal knee", "Train legs weaker");
//        save(p1);
//        save(p2);
//        save(p3);
//    }
}
