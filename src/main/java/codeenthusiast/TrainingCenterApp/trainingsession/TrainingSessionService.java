package codeenthusiast.TrainingCenterApp.trainingsession;

import java.util.List;

public interface TrainingSessionService {

    TrainingSession findEntityById(Long trainingPlanId);

    TrainingSessionDTO findById(Long id);

    TrainingSessionDTO save(TrainingSession trainingSession, Long trainingPlanId);

    TrainingSessionDTO save(TrainingSession trainingSession);

    List<TrainingSessionDTO> getAllByTrainingPlanId(Long id);

    TrainingSessionDTO update(Long id, TrainingSessionDTO dto);

    TrainingSession updateData(TrainingSession oldSession, TrainingSessionDTO dto);

    TrainingSessionDTO create(TrainingSessionDTO dto, Long trainingPlanId);

    void deleteById(Long id);
}
