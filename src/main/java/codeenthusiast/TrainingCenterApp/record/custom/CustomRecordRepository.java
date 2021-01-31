package codeenthusiast.TrainingCenterApp.record.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRecordRepository extends JpaRepository<CustomRecord, Long> {

    List<CustomRecord> findAllByPersonalRecordsId(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM custom_record WHERE personal_records_id = ? " +
            "ORDER BY date DESC LIMIT 3")
    List<CustomRecord> findThreeLatestByPersonalRecordsId(Long id);
}
