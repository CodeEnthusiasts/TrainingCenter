package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import java.util.List;

public interface StrengthExerciseService {

    StrengthExerciseDTO findById(Long id);

    StrengthExerciseDTO save(StrengthExerciseDTO dto);

    List<StrengthExerciseDTO> getAllByTrainingSessionId(Long id);

    StrengthExerciseDTO create(StrengthExerciseDTO dto);

    StrengthExerciseDTO update(Long id, StrengthExerciseDTO dto);

    void deleteById(Long id);


}
