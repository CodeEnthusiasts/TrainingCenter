package codeenthusiast.TrainingCenterApp.record;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalRecordsRepository extends AbstractRepository<PersonalRecords> {

    Optional<PersonalRecords> findByUserId(Long id);

}
