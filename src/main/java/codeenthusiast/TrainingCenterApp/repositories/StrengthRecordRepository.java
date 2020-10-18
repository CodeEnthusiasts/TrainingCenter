package codeenthusiast.TrainingCenterApp.repositories;

import codeenthusiast.TrainingCenterApp.entities.records.StrengthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrengthRecordRepository extends JpaRepository<StrengthRecord, Long> {

    List<StrengthRecord> findByExerciseName(String exerciseName);

    void deleteByExerciseNameAndWeightAndRepetition(String exerciseName, int weight, int repetition);

    List<StrengthRecord> findByExerciseNameAndRepetition(String exerciseName, int repetition);
}
