package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.PaceMapper;
import org.springframework.stereotype.Service;

@Service
public class PaceServiceImpl implements PaceService{

    private final PaceRepository paceRepository;

    private final PaceMapper paceMapper;

    public PaceServiceImpl(PaceRepository paceRepository, PaceMapper paceMapper) {
        this.paceRepository = paceRepository;
        this.paceMapper = paceMapper;
    }
}
