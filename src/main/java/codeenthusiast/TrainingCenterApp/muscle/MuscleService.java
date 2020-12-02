package codeenthusiast.TrainingCenterApp.muscle;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MuscleService {

    void deleteById(Long id);

    boolean isExistsById(Long id);

    void checkExistenceByName(String name);

    List<MuscleDTO> findByMovementId(Long id);

    MuscleDTO findById(Long id);

    MuscleDTO update(Long id, MuscleDTO dto);

    MuscleDTO create(MuscleDTO dto);

    MuscleDTO save(MuscleDTO dto);

    MuscleDTO addImage(Long id, MultipartFile file);

    MuscleDTO removeAllImages(Long id);
}
