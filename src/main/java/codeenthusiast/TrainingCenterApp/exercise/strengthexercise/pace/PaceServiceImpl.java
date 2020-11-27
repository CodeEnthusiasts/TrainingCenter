package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.pace;

import org.springframework.stereotype.Service;

@Service
public class PaceServiceImpl implements PaceService {

    private final PaceRepository paceRepository;

    public PaceServiceImpl(PaceRepository paceRepository) {
        this.paceRepository = paceRepository;
    }
}
