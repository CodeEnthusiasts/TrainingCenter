package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace;

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
