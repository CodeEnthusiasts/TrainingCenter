package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.PaceMapper;
import org.springframework.stereotype.Service;

@Service
public class PaceServiceImpl extends AbstractServiceImpl<Pace, PaceDTO>
        implements PaceService {
    private PaceRepository paceRepository;

    private PaceMapper paceMapper;

    public PaceServiceImpl(AbstractRepository<Pace> repository, AbstractMapper<Pace,
            PaceDTO> mapper, PaceRepository paceRepository, PaceMapper paceMapper) {
        super(repository, mapper);
        this.paceRepository = paceRepository;
        this.paceMapper = paceMapper;
    }
}
