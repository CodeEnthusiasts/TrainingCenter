package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService, SecurityService {

    private final TrainingSessionRepository repository;

    private final TrainingSessionMapper mapper;

    private final TrainingPlanServiceImpl trainingPlanService;

    public TrainingSessionServiceImpl(TrainingSessionRepository repository,
                                      TrainingSessionMapper mapper,
                                      TrainingPlanServiceImpl trainingPlanService) {
        this.repository = repository;
        this.mapper = mapper;
        this.trainingPlanService = trainingPlanService;
    }

    @Override
    public TrainingSession getTrainingSessionEntityById(Long trainingPlanId) {
        TrainingSession trainingSession = repository.findById(trainingPlanId)
                                                    .orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(trainingSession));
        return trainingSession;
    }

    @Override
    public TrainingSessionDTO getTrainingSessionById(Long id) {
        return mapToDTO(getTrainingSessionEntityById(id));
    }

    @Override
    public List<TrainingSessionDTO> getAllTrainingSessionsByTrainingPlanId(Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        return mapToDTOs(trainingPlan.getTrainingSessions());
    }

    @Override
    @Transactional
    public TrainingSessionDTO createTrainingSession(TrainingSessionDTO dto, Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        TrainingSession trainingSession = new TrainingSession(dto);
        trainingSession.setTrainingPlan(trainingPlan);
        return mapToDTO(save(trainingSession));
    }

    @Override
    @Transactional
    public TrainingSessionDTO updateTrainingSession(Long id, TrainingSessionDTO dto) {
        TrainingSession trainingSession = getTrainingSessionEntityById(id);
        updateData(trainingSession, dto);
        return mapToDTO(trainingSession);
    }

    @Override
    public String deleteTrainingSession(Long id) {
        repository.delete(getTrainingSessionEntityById(id));
        return "Training session deleted successfully. ";
    }

    private boolean hasAccess(TrainingSession trainingSession) {
        return trainingSession.getTrainingPlan().getUser().getId().equals(getPrincipal().getId());
    }

    private TrainingSession save(TrainingSession trainingSession) {
        return repository.save(trainingSession);
    }

    private void updateData(TrainingSession oldSession, TrainingSessionDTO dto) {
        oldSession.setDate(dto.getDate());
        oldSession.setDayOfWeek(dto.getDayOfWeek());
        oldSession.setDifficulty(dto.getDifficulty());
        oldSession.setEndTime(dto.getEndTime());
        oldSession.setStartTime(dto.getStartTime());
        oldSession.setName(dto.getName());
        oldSession.setNotes(dto.getNotes());
    }

    private TrainingSessionDTO mapToDTO(TrainingSession trainingSession) {
        return mapper.mapToDTO(trainingSession);
    }

    private List<TrainingSessionDTO> mapToDTOs(List<TrainingSession> list) {
        return mapper.mapToDTOs(list);
    }

    public TrainingSession getTest(Long id) {
        return repository.findById(id).get();
    }
}
