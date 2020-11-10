package codeenthusiast.TrainingCenterApp.record.endurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnduranceRecordRepository extends JpaRepository<EnduranceRecord, Long> {

//    List<EnduranceRecord> findByExerciseName(String exerciseName);
//
//    void deleteByExerciseNameAndDistanceAndTime(String exerciseName, int distance, int time);
//
//    List<EnduranceRecord> findByExerciseNameAndTime(String exerciseName, int time);
}
