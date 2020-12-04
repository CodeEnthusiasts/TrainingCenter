package codeenthusiast.TrainingCenterApp.muscle;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MuscleService {

    Muscle findEntityById(Long id);

    MuscleDTO findById(Long id);

    List<MuscleDTO> findByMovementId(Long id);

    boolean existsById(Long id);

    void checkExistenceByName(String name);

    MuscleDTO update(Long id, MuscleDTO dto);

    MuscleDTO create(MuscleDTO dto);

    MuscleDTO save(Muscle muscle);

    MuscleDTO addImage(Long id, MultipartFile file);

    MuscleDTO removeAllImages(Long id);

    void deleteById(Long id);
}
