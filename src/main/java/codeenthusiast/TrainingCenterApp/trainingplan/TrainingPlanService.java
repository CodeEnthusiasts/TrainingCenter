package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;

import java.util.List;

public interface TrainingPlanService  {

    TrainingPlanSuperficialDTO findById (Long id);
    List<TrainingPlanSuperficialDTO> getAll();

    TrainingPlanDTO save (TrainingPlanDTO dto);
    TrainingPlanDTO update (Long id, TrainingPlanDTO dto);

    void delete (Long id);

}
