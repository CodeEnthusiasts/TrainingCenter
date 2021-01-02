package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingSessionRepository extends AbstractRepository<TrainingSession> {

    List<TrainingSession> findAllByTrainingPlanId(Long id);

    List<StrengthExercise> findAllStrengthExecisesBySessionId(Long sessionId);
}
