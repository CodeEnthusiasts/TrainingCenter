package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends AbstractRepository<Image> {
    void deleteByMovementId(Long id);

    void deleteByMuscleId(Long id);

    void deleteByUserId(Long id);

    boolean existsByUserId(Long userId);
}
