package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import java.util.List;

public interface StrengthExerciseService {

    StrengthExercise findEntityById(Long id);

    StrengthExerciseDTO findById(Long id);

    StrengthExerciseDTO save(StrengthExercise strengthExercise, Long trainingSessionId, Long movementId);

    List<StrengthExerciseDTO> getAllByTrainingSessionId(Long id);

    StrengthExerciseDTO create(StrengthExerciseDTO dto, Long trainingSessionId, Long movementId);

    StrengthExerciseDTO update(Long id, StrengthExerciseDTO dto);

    void deleteById(Long id);

}
