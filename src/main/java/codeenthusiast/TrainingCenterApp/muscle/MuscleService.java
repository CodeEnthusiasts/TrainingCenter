package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;

public interface MuscleService extends AbstractService<Muscle, MuscleDTO> {

    boolean existsById(Long id);

    boolean existsByName(String name);

    MuscleDTO addImage(Long id, ImageDTO image);

    void removeImage(Long id);
}
