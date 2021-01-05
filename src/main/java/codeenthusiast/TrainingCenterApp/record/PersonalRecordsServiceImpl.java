package codeenthusiast.TrainingCenterApp.record;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonalRecordsServiceImpl implements PersonalRecordsService, SecurityService {

    private final PersonalRecordsRepository repository;

    public PersonalRecordsServiceImpl(PersonalRecordsRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonalRecords getPersonalRecordsByUserId(Long userId) {
        return repository.findByUserId(userId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public PersonalRecords getPersonalRecordsEntityById(Long id) {
        PersonalRecords personalRecords = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(personalRecords));
        return personalRecords;
    }

    private boolean hasAccess(PersonalRecords personalRecords) {
        return personalRecords.getUser().getId().equals(getPrincipalId());
    }
}
