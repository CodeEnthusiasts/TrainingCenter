package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.image.ImageDTO;

import java.util.List;

public interface MovementService {

    void deleteById(Long id);

    void checkExistence(Long id);

    void checkExistenceByName(String name);

    MovementDTO findById(Long id);

    MovementDTO update(Long id, MovementDTO dto);

    MovementDTO create(MovementDTO dto);

    MovementDTO save(MovementDTO dto);

    MovementDTO addImage(Long id, ImageDTO image);

    List<Long> removeAllImages(Long id);

    List<Long> getIdOfDeletedImages(List<ImageDTO> images);

    Movement findEntityById(Long id);
}
