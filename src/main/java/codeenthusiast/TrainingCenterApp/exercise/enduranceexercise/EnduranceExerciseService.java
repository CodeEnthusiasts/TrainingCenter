package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import java.util.List;

public interface EnduranceExerciseService {

    EnduranceExercise getEnduranceExerciseEntityById(Long id);

    EnduranceExerciseDTO getEnduranceExerciseById(Long id);

    EnduranceExerciseDTO createEnduranceExercise(EnduranceExerciseDTO dto, Long trainingSessionId, Long movementId);

    EnduranceExerciseDTO updateEnduranceExercise(Long id, EnduranceExerciseDTO dto);

    List<EnduranceExerciseDTO> getAllEnduranceExercisesByTrainingSessionId(Long id);

    String deleteEnduranceExercise(Long id);
}
