package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;

import java.util.List;

public interface EnduranceExerciseService {

    EnduranceExerciseDTO findById(Long id);

    EnduranceExerciseDTO save(EnduranceExercise enduranceExercise, Long trainingPlanId, Long movementId);

    List<EnduranceExerciseDTO> getAllByTrainingSessionId(Long id);

    EnduranceExerciseDTO create(EnduranceExerciseDTO dto, Long trainingPlanId, Long movementId);

    EnduranceExerciseDTO update(Long id, EnduranceExerciseDTO dto);

    void deleteById(Long id);
}
