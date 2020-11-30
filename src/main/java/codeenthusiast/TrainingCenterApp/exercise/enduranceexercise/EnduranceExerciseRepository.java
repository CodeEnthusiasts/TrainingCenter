package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnduranceExerciseRepository extends AbstractRepository<EnduranceExercise> {

    EnduranceExercise findById(long id);

    List<EnduranceExercise> findAllByTrainingSessionId(Long id);
}
