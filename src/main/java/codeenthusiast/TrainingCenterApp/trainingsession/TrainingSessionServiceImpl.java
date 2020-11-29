package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanServiceImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            if(!hasAccess(trainingSession)){
                throw new AccessDeniedException("Access Denied");
            }
            return trainingSessionMapper.mapToDTO(trainingSession);
    }

    @Override
    public TrainingSessionDTO save(TrainingSession trainingSession, Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        trainingSession.setTrainingPlan(trainingPlan);
        TrainingSession newSession = trainingSessionRepository.save(trainingSession);

        return trainingSessionMapper.mapToDTO(newSession);
    }

    public TrainingSessionDTO save(TrainingSessionDTO oldSession) {
        TrainingSession entity = trainingSessionMapper.mapToEntity(oldSession);

        return trainingSessionMapper.mapToDTO(trainingSessionRepository.save(entity));
    }

    @Override
    public List<TrainingSessionDTO> getAllByTrainingPlanId(Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        if(!trainingPlanService.hasAccess(trainingPlan)){
            throw  new AccessDeniedException("Access denied");
        }
        List<TrainingSession> trainingSessions = trainingSessionRepository.findAllByTrainingPlanId(trainingPlanId);
        return trainingSessionMapper.mapToDTOs(trainingSessions);
    }

    @Override
    public TrainingSessionDTO create(TrainingSessionDTO dto, Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanEntityById(trainingPlanId);
        if(!trainingPlanService.hasAccess(trainingPlan)){
            throw  new AccessDeniedException("Access denied");
        }
        TrainingSession trainingSession = new TrainingSession(dto);
        return save(trainingSession, trainingPlanId);
    }

    @Override
    public TrainingSessionDTO update(Long id, TrainingSessionDTO dto) {
        TrainingSession oldSession = findEntityById(id);
        if(!hasAccess(oldSession)){
            throw new AccessDeniedException("Access denied");
        }
        oldSession.setDate(dto.getDate());
        oldSession.setDayOfWeek(dto.getDayOfWeek());
        oldSession.setDifficulty(dto.getDifficulty());
        oldSession.setEndTime(dto.getEndTime());
        oldSession.setStartTime(dto.getStartTime());
        oldSession.setName(dto.getName());
        oldSession.setNotes(dto.getNotes());

        return trainingSessionMapper.mapToDTO(trainingSessionRepository.save(oldSession));
    }

    @Override
    public void deleteById(Long id) {
        TrainingSession oldSession = findEntityById(id);
        if(!hasAccess(oldSession)){
            throw new AccessDeniedException("Access denied");
        }
        trainingSessionRepository.deleteById(id);
    }

    public boolean hasAccess(TrainingSession trainingSession) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return trainingSession.getTrainingPlan().getUser().getId().equals(userDetailsImpl.getId());
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }
}
