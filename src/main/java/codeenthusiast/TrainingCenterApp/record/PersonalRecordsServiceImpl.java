package codeenthusiast.TrainingCenterApp.record;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import org.springframework.stereotype.Service;

@Service
public class PersonalRecordsServiceImpl implements PersonalRecordsService, SecurityService {

    private final PersonalRecordsRepository repository;

    public PersonalRecordsServiceImpl(PersonalRecordsRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonalRecords getPersonalRecordsByUserId(Long userId) {
        return getNotNullPersonalRecordsByUserIdFromRepo(userId);
    }

    @Override
    public PersonalRecords getPersonalRecordsById(Long personalRecordsId) {
        return getNotNullPersonalRecordsByIdFromRepo(personalRecordsId);
    }

    @Override
    public boolean hasAccess(PersonalRecords personalRecords) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return personalRecords.getUser().getId().equals(userDetailsImpl.getId());
    }

    private PersonalRecords getNotNullPersonalRecordsByUserIdFromRepo(long id) {
        return repository.findByUserId(id).orElseThrow(EntityNotFoundException::new);
    }

    private PersonalRecords getNotNullPersonalRecordsByIdFromRepo(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
