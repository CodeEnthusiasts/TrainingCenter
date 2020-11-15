package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrengthRecordRepository extends AbstractRepository<StrengthRecord> {

    StrengthRecord findById(long id);

    void deleteById(Long id);

    List<StrengthRecord> findAllByPersonalRecordsId(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM personal_records WHERE personal_records_id = ? " +
            "ORDER BY set_date DESC LIMIT 3")
    List<StrengthRecord> findThreeLatestByPersonalRecordsId(Long id);

}
