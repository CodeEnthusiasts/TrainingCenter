package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingSessionRepository extends AbstractRepository<TrainingSession> {
    List<TrainingSession> findAllByTrainingPlanId(Long id);
}
