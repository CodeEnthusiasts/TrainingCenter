package codeenthusiast.TrainingCenterApp.priority;

import java.util.List;

public interface PriorityService {

    Priority findEntityById(Long id);

    PriorityDTO findById(Long id);

    List<PriorityDTO> getAllByTrainingPlanId(Long id);

    void updateData(Priority priority, PriorityDTO dto);

    PriorityDTO update(Long id, PriorityDTO dto);

    PriorityDTO create(Long id, PriorityDTO dto);

    PriorityDTO save(Priority priority);

    void deleteById(Long id);
}
