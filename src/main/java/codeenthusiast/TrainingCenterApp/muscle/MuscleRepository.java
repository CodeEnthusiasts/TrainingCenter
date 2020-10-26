package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractReposiotory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuscleRepository extends AbstractReposiotory<Muscle> {


    Optional<Muscle> findByName(String name);

    void deleteByName(String name);

    boolean existsByName(String name);

    boolean existsById(Long id);
}
