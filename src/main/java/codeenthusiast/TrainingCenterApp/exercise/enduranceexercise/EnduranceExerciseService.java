package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;

import java.util.List;

public interface EnduranceExerciseService {

    EnduranceExercise getEnduranceExerciseEntityById(Long id);

    EnduranceExerciseDTO createEnduranceExercise(EnduranceExerciseDTO dto, Long trainingSessionId, Long movementId);

    EnduranceExerciseDTO updateEnduranceExercise(Long id, EnduranceExerciseDTO dto);

    EnduranceExerciseDTO getEnduranceExerciseById(Long id);

    List<EnduranceExerciseDTO> getAllEnduranceExercisesByTrainingSessionId(Long id);

    String deleteEnduranceExercise(Long id);
}
