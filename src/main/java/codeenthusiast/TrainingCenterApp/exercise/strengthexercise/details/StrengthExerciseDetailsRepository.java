package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrengthExerciseDetailsRepository extends AbstractRepository<StrengthExerciseDetails> {

    StrengthExerciseDetails findById(long id);
}
