package codeenthusiast.TrainingCenterApp.trainingsession;

import java.util.List;

public interface TrainingSessionService {

    TrainingSession getTrainingSessionEntityById(Long trainingPlanId);

    TrainingSessionDTO getTrainingSessionById(Long id);

    List<TrainingSessionDTO> getAllTrainingSessionsByTrainingPlanId(Long id);

    TrainingSessionDTO createTrainingSession(TrainingSessionDTO dto, Long trainingPlanId);

    TrainingSessionDTO updateTrainingSession(Long id, TrainingSessionDTO dto);

    String deleteTrainingSession(Long id);
}
