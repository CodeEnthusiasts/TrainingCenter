package codeenthusiast.TrainingCenterApp.trainingplan;

import java.util.List;

public interface TrainingPlanService {

    TrainingPlan findEntityById(Long id);

    TrainingPlanSuperficialDTO findById(Long id);

    List<TrainingPlanSuperficialDTO> getAll();

    TrainingPlanDTO save(TrainingPlanDTO dto);

    TrainingPlanDTO update(Long id, TrainingPlanDTO dto);

    void delete(Long id);

}
