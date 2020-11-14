package codeenthusiast.TrainingCenterApp.muscle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Long> {

    boolean existsByName(String name);
}
