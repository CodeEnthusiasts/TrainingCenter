package codeenthusiast.TrainingCenterApp.muscle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Long> {


    Optional<Muscle> findByName(String name);

    void deleteByName(String name);

    boolean existsByName(String name);
}
