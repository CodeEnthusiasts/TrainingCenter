package codeenthusiast.TrainingCenterApp.record;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PersonalRecordsServiceImpl implements PersonalRecordsService {

    private final PersonalRecordsRepository repository;

    public PersonalRecordsServiceImpl(PersonalRecordsRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonalRecords getPersonalRecordsByUserId(Long userId) {
        return getPersonalRecordsByUserIdFromRepo(userId);
    }

    public PersonalRecords getPersonalRecordsById(Long personalRecordsId) {
        PersonalRecords personalRecords = getPersonalRecordsByIdFromRepo(personalRecordsId);
        if(isNull(personalRecords))
            throw new EntityNotFoundException("Resource not available");
        return getPersonalRecordsByIdFromRepo(personalRecordsId);
    }

    @Override
    public PersonalRecords savePersonalRecords(PersonalRecords personalRecords) {
        return save(personalRecords);
    }

    public boolean hasAccess(PersonalRecords personalRecords) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return personalRecords.getUser().getId().equals(userDetailsImpl.getId());
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }

    private boolean isNull(PersonalRecords personalRecords) {
        return personalRecords == null;
    }

    private PersonalRecords save(PersonalRecords personalRecords) {
        return repository.save(personalRecords);
    }

    private PersonalRecords getPersonalRecordsByUserIdFromRepo(long id) {
        return repository.findByUserId(id);
    }

    private PersonalRecords getPersonalRecordsByIdFromRepo(long id) {
        return repository.findById(id);
    }
}
