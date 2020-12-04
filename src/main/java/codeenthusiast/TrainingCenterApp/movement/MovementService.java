package codeenthusiast.TrainingCenterApp.movement;

import org.springframework.web.multipart.MultipartFile;

public interface MovementService {

    boolean isExistsById(Long id);

    void checkExistenceByName(String name);

    Movement findEntityById(Long id);

    MovementDTO findById(Long id);

    MovementDTO create(MovementDTO dto);

    MovementDTO save(Movement movement);

    MovementDTO update(Long id, MovementDTO dto);

    void deleteById(Long id);

    MovementDTO addImage(Long id, MultipartFile file);

    MovementDTO removeAllImages(Long id);

}
