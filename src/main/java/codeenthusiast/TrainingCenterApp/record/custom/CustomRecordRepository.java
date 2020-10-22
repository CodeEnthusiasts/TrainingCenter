package codeenthusiast.TrainingCenterApp.record.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomRecordRepository extends JpaRepository<CustomRecord, Long> {

    Optional<CustomRecord> findByDescription(String description);

    boolean existsByDescription(String description);

    void deleteByDescription(String description);
}
