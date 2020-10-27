package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaceRepository extends JpaRepository<Pace, Long> {
}
