package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.mappers.TrainingSessionMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

    private TrainingSessionRepository trainingSessionRepository;

    private TrainingSessionMapper trainingSessionMapper;

    public TrainingSessionServiceImpl(TrainingSessionRepository trainingSessionRepository,
                                      TrainingSessionMapper trainingSessionMapper) {
        this.trainingSessionRepository = trainingSessionRepository;
        this.trainingSessionMapper = trainingSessionMapper;
    }

    @Override
    public TrainingSessionDTO findById(Long id) {
        return null;
    }

    public TrainingSession findEntityById(Long id){
        return trainingSessionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    @Override
    public List<TrainingSessionDTO> getAll() {
        return null;
    }

    @Override
    public TrainingSessionDTO save(TrainingSessionDTO dto) {
        return null;
    }

    @Override
    public TrainingSessionDTO update(Long id, TrainingSessionDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
