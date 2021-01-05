package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnduranceRecordRepository extends AbstractRepository<EnduranceRecord> {

    List<EnduranceRecord> findAllByPersonalRecordsId(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM endurance_record WHERE personal_records_id = ? " +
            "ORDER BY date DESC LIMIT 3")
    List<EnduranceRecord> findThreeLatestByPersonalRecordsId(Long id);

}
