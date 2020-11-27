package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends AbstractRepository<Priority> {
    List<Priority> findAllByTrainingPlanId(Long id);
}
