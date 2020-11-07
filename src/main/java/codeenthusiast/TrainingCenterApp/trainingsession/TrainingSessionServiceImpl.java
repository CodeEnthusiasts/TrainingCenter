package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.TrainingSessionMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TrainingSessionServiceImpl extends AbstractServiceImpl<TrainingSession, TrainingSessionDTO>
        implements TrainingSessionService {

    private TrainingSessionRepository trainingSessionRepository;

    private TrainingSessionMapper trainingSessionMapper;

    public TrainingSessionServiceImpl(AbstractRepository<TrainingSession> repository, AbstractMapper<TrainingSession,
            TrainingSessionDTO> mapper, TrainingSessionRepository trainingSessionRepository, TrainingSessionMapper trainingSessionMapper) {
        super(repository, mapper);
        this.trainingSessionRepository = trainingSessionRepository;
        this.trainingSessionMapper = trainingSessionMapper;
    }

}
