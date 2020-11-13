package codeenthusiast.TrainingCenterApp.muscle;

import codeenthusiast.TrainingCenterApp.image.ImageDTO;

import java.util.List;

public interface MuscleService {

    void deleteById(Long id);

    void checkExistence(Long id);

    void checkExistenceByName(String name);

    MuscleDTO findById(Long id);

    MuscleDTO update(Long id, MuscleDTO dto);

    MuscleDTO create(MuscleDTO dto);

    MuscleDTO save(MuscleDTO dto);

    MuscleDTO addImage(Long id, ImageDTO image);

    List<Long> removeAllImages(Long id);

    List<Long> getIdOfDeletedImages(List<ImageDTO> images);


}
