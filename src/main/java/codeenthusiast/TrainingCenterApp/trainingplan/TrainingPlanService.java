package codeenthusiast.TrainingCenterApp.trainingplan;

import java.util.List;

public interface TrainingPlanService {

    TrainingPlanDTO createTrainingPlan(Long userId, TrainingPlanDTO dto);

    TrainingPlanDTO updateTrainingPlan(Long id, TrainingPlanDTO dto);

    List<TrainingPlanDTO> getAllTrainingPlansByUserId(Long id);

    TrainingPlanDTO getTrainingPlanById(Long id);

    String deleteTrainingPlan(Long id);
}
