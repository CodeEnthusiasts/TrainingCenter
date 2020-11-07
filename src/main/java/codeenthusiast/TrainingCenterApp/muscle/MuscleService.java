package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.image.Image;

public interface MuscleService extends AbstractService<Muscle, MuscleDTO> {

    boolean existsById(Long id);

    boolean existsByName(String name);

}
