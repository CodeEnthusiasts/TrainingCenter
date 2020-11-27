package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrengthExerciseRepository extends AbstractRepository<StrengthExercise> {

    List<StrengthExercise> findAllByTrainingSessionId(Long id);

    StrengthExercise findById(long id);

}
