package codeenthusiast.TrainingCenterApp.record;

import org.springframework.stereotype.Service;

@Service
public class PersonalRecordsServiceImpl implements PersonalRecordsService {

    private final PersonalRecordsRepository personalRecordsRepository;

    public PersonalRecordsServiceImpl(PersonalRecordsRepository personalRecordsRepository) {
        this.personalRecordsRepository = personalRecordsRepository;
    }

    @Override
    public PersonalRecords getPersonalRecordsById(Long id) {
        return getPersonalRecordsByIdFromRepo(id);
    }


    private PersonalRecords getPersonalRecordsByIdFromRepo(long id) {
        return personalRecordsRepository.findById(id);
    }

}
