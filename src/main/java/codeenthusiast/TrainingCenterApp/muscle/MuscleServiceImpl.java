package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.mappers.MuscleMapper;
import codeenthusiast.TrainingCenterApp.user.major.UserDTO;
import org.springframework.stereotype.Service;

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

    @Override
    public MuscleDTO addImage(Long id, ImageDTO image) {
        MuscleDTO muscle = findById(id);
        muscle.setImageUrl(image.getFileUrl());
        return save(muscle);
    }

    @Override
    public void removeImage(Long id) {
        MuscleDTO muscle = findById(id);
        muscle.setImageUrl(null);
        save(muscle);
    }


}
