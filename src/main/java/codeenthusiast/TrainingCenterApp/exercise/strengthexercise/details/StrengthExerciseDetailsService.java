package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details;

public interface StrengthExerciseDetailsService {

    StrengthExerciseDetailsDTO getStrengthExerciseDetailsById(Long id);

    StrengthExerciseDetailsDTO createStrengthExerciseDetails(Long id,
                                                             StrengthExerciseDetailsDTO strengthExerciseDetailsDTO);

    StrengthExerciseDetailsDTO updateStrengthExerciseDetails(Long id,
                                                             StrengthExerciseDetailsDTO strengthExerciseDetailsDTO);
}
