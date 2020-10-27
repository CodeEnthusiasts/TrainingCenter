package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import codeenthusiast.TrainingCenterApp.image.Image;

public interface MuscleService extends AbstractService<Muscle, MuscleDTO> {

    boolean existsById(Long id);

    boolean existsByName(String name);

    MuscleDTO addImageToMuscle(Long id, String filePath);

    void addImage(Muscle muscle, Image image);

    void deleteImageFromMuscle(Long id, String fileUrl);

    void removeImage(Muscle muscle, Image image);

    void removeAllImages(Muscle muscle);

}
