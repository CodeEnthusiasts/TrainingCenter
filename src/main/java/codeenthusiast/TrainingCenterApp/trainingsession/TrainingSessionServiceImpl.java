package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.mappers.TrainingSessionMapper;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;

    private final TrainingPlanServiceImpl trainingPlanService;

    private final TrainingSessionMapper trainingSessionMapper;

    public TrainingSessionServiceImpl(TrainingSessionRepository trainingSessionRepository, TrainingPlanServiceImpl trainingPlanService, TrainingSessionMapper trainingSessionMapper) {
        this.trainingSessionRepository = trainingSessionRepository;
        this.trainingPlanService = trainingPlanService;
        this.trainingSessionMapper = trainingSessionMapper;
    }


    public TrainingSession findEntityById(Long trainingPlanId) {
        return trainingSessionRepository.findById(trainingPlanId).orElseThrow(
                () -> new EntityNotFoundException(trainingPlanId));
    }

    @Override
    public TrainingSessionDTO findById(Long id) {
            TrainingSession trainingSession = trainingSessionRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException(id));
            return trainingSessionMapper.mapToDTO(trainingSession);
    }

    @Override
    public TrainingSessionDTO save(TrainingSession trainingSession, Long trainingPlanId) {

        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanById(trainingPlanId);
        trainingSession.setTrainingPlan(trainingPlan);
        TrainingSession newSession = trainingSessionRepository.save(trainingSession);

        return trainingSessionMapper.mapToDTO(newSession);
    }

    public TrainingSessionDTO save(TrainingSessionDTO oldSession) {
        TrainingSession entity = trainingSessionMapper.mapToEntity(oldSession);

        return trainingSessionMapper.mapToDTO(trainingSessionRepository.save(entity));
    }

    @Override
    public List<TrainingSessionDTO> getAllByTrainingPlanId(Long id) {
        return trainingSessionMapper.mapToDTOs(trainingSessionRepository.findAllByTrainingPlanId(id));
    }

    @Override
    public TrainingSessionDTO create(TrainingSessionDTO dto, Long trainingPlanId) {
        TrainingSession trainingSession = new TrainingSession(dto);
        return save(trainingSession, trainingPlanId);
    }

    @Override
    public TrainingSessionDTO update(Long id, TrainingSessionDTO dto) {

        TrainingSessionDTO oldSession = findById(id);
        oldSession.setDate(dto.getDate());
        oldSession.setDayOfWeek(dto.getDayOfWeek());
        oldSession.setDifficulty(dto.getDifficulty());
        oldSession.setEndTime(dto.getEndTime());
        oldSession.setStartTime(dto.getStartTime());
        oldSession.setName(dto.getName());
        oldSession.setNotes(dto.getNotes());

        return save(oldSession);
    }

    @Override
    public void deleteById(Long id) {
        trainingSessionRepository.deleteById(id);
    }
}
