package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuscleRepository extends AbstractRepository<Muscle> {


    Optional<Muscle> findByName(String name);

    void deleteByName(String name);

    boolean existsByName(String name);

    boolean existsById(Long id);
}
