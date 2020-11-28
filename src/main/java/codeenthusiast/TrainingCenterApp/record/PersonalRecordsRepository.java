package codeenthusiast.TrainingCenterApp.record;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRecordsRepository extends AbstractRepository<PersonalRecords> {

    PersonalRecords findByUserId(long id);

}
