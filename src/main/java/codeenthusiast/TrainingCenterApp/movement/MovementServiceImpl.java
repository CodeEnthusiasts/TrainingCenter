package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.MovementMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MovementServiceImpl extends AbstractServiceImpl<Movement, MovementDTO>
        implements MovementService {

    private MovementRepository movementRepository;

    private MovementMapper movementMapper;

    public MovementServiceImpl(AbstractRepository<Movement> repository, AbstractMapper<Movement,
            MovementDTO> mapper, MovementRepository movementRepository, MovementMapper movementMapper) {
        super(repository, mapper);
        this.movementRepository = movementRepository;
        this.movementMapper = movementMapper;
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        MovementDTO movement = new MovementDTO("Squat", null, null);
//        MovementDTO bench = new MovementDTO("Bench", null, null);
//        MovementDTO deadlift = new MovementDTO("Deadlift", null, null);
//        save(movement);
//        save(bench);
//        save(deadlift);
//    }
}
