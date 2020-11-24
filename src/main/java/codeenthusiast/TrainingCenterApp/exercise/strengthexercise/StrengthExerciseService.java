package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import java.util.List;

public interface StrengthExerciseService {

    StrengthExerciseDTO findById(Long id);

    StrengthExerciseDTO save(StrengthExercise strengthExercise, Long trainingPlanId, Long movementId);

    List<StrengthExerciseDTO> getAllByTrainingSessionId(Long id);

    StrengthExerciseDTO create(StrengthExerciseDTO dto, Long trainingPlanId, Long movementId);

    StrengthExerciseDTO update(Long id, StrengthExerciseDTO dto);

    void deleteById(Long id);


}
