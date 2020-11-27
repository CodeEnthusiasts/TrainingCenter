package codeenthusiast.TrainingCenterApp.trainingsession;

import java.util.List;

public interface TrainingSessionService {

    TrainingSessionDTO findById(Long id);

    TrainingSessionDTO save(TrainingSession trainingSession, Long trainingPlanId);

    TrainingSessionDTO save(TrainingSessionDTO trainingSession);

    List<TrainingSessionDTO> getAllByTrainingPlanId(Long id);

    TrainingSessionDTO create(TrainingSessionDTO dto, Long trainingPlanId);

    TrainingSessionDTO update(Long id, TrainingSessionDTO dto);

    void deleteById(Long id);
}
