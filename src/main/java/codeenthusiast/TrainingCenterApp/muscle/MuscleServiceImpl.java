package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.image.Image;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.mappers.MuscleMapper;
import codeenthusiast.TrainingCenterApp.movement.MovementDTO;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MuscleServiceImpl extends AbstractServiceImpl<Muscle, MuscleDTO> implements MuscleService {

    private final MuscleRepository repository;
    private final MuscleMapper mapper;


    public MuscleServiceImpl(AbstractRepository<Muscle> repository, AbstractMapper<Muscle, MuscleDTO> mapper, MuscleRepository repository1, MuscleMapper mapper1) {
        super(repository, mapper);
        this.repository = repository1;
        this.mapper = mapper1;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        MuscleDTO muscle = new MuscleDTO("Quadratus", "Biggest human muscle");
//        MuscleDTO muscle1 = new MuscleDTO("Chest", "Pecs description muscle");
//        MuscleDTO muscle2 = new MuscleDTO("Erector spinae", "Long human muscle on the back");
//        save(muscle);
//        save(muscle1);
//        save(muscle2);
//    }

}
