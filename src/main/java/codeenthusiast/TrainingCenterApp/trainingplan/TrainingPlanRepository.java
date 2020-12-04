package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingPlanRepository extends AbstractRepository<TrainingPlan>  {

    List<TrainingPlan> findAllByUserId(Long id);

    void deleteById(Long id);

}
