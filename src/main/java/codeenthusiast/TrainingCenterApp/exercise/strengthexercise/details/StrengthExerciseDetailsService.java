package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

public interface StrengthExerciseDetailsService {

    StrengthExerciseDetails getEntityById(Long id);

    StrengthExerciseDetailsDTO getById(Long id);

    StrengthExerciseDetailsDTO create(Long id, StrengthExerciseDetailsDTO strengthExerciseDetailsDTO);

    StrengthExerciseDetailsDTO update(Long id, StrengthExerciseDetailsDTO strengthExerciseDetailsDTO);




}
