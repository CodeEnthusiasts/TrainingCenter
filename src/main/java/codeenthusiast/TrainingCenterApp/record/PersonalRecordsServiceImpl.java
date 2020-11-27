package codeenthusiast.TrainingCenterApp.record;

import org.springframework.stereotype.Service;

@Service
public class PersonalRecordsServiceImpl implements PersonalRecordsService {

    private final PersonalRecordsRepository repository;

    public PersonalRecordsServiceImpl(PersonalRecordsRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonalRecords getPersonalRecordsById(Long id) {
        return getPersonalRecordsByIdFromRepo(id);
    }

    @Override
    public PersonalRecords savePersonalRecords(PersonalRecords personalRecords) {
        return repository.save(personalRecords);
    }

    private PersonalRecords getPersonalRecordsByIdFromRepo(long id) {
        return repository.findById(id);
    }

}
