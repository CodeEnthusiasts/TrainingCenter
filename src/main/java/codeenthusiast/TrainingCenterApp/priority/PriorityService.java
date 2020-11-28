package codeenthusiast.TrainingCenterApp.priority;

import java.util.List;

public interface PriorityService {

    void deleteById(Long id);

    List<PriorityDTO> getAllByTrainingPlanId(Long id);

    PriorityDTO findById(Long id);

    PriorityDTO update(Long id, PriorityDTO dto);

    PriorityDTO create(Long id, PriorityDTO dto);

    PriorityDTO save(PriorityDTO dto);
}
