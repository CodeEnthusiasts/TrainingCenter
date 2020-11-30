package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomRecordServiceImpl implements CustomRecordService {

    private final CustomRecordRepository repository;

    private final CustomRecordMapper mapper;

    private final PersonalRecordsServiceImpl personalRecordsServiceImpl;

    public CustomRecordServiceImpl(CustomRecordRepository repository,
                                   CustomRecordMapper mapper,
                                   PersonalRecordsServiceImpl personalRecordsServiceImpl) {
        this.repository = repository;
        this.mapper = mapper;
        this.personalRecordsServiceImpl = personalRecordsServiceImpl;
    }

    @Override
    public CustomRecordDTO createCustomRecord(Long personalRecordsId, CustomRecordDTO customRecordDTO) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId);
        if(isNull(personalRecords))
            throw new EntityNotFoundException("Resource not available");
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        CustomRecord customRecord = mapToEntity(customRecordDTO);
        customRecord.setPersonalRecords(personalRecords);
        return mapToDTO(save(customRecord));
    }

    @Override
    public CustomRecordDTO updateCustomRecord(Long customRecordId, CustomRecordDTO customRecordDTO) {
        CustomRecord customRecord = getCustomRecordByIdFromRepo(customRecordId);
        if(isNull(customRecord))
            throw new EntityNotFoundException("Resource not available");
        if(!hasAccess(customRecord))
            throw new AccessDeniedException("Access denied");
        updateCustomRecord(customRecord, customRecordDTO);
        return mapToDTO(save(customRecord));
    }

    @Override
    public List<CustomRecordDTO> getAllCustomRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId);
        if(isNull(personalRecords))
            throw new EntityNotFoundException("Resource not available");
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        return mapToDTOs(repository.findAllByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public List<CustomRecordDTO> getThreeLatestCustomRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId);
        if(isNull(personalRecords))
            throw new EntityNotFoundException("Resource not available");
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public String deleteCustomRecord(Long customRecordId) {
        CustomRecord customRecord = getCustomRecordByIdFromRepo(customRecordId);
        if(isNull(customRecord))
            throw new EntityNotFoundException("Resource not available");
        if(!hasAccess(customRecord))
            throw new AccessDeniedException("Access denied");
        deleteById(customRecordId);
        return "Record deleted successfully. ";
    }

    private boolean hasAccess(CustomRecord customRecord) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        return customRecord.getPersonalRecords().getUser().getId().equals(userDetailsImpl.getId());
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private CustomRecord save(CustomRecord customRecord) {
        return repository.save(customRecord);
    }

    private CustomRecord getCustomRecordByIdFromRepo(long id) {
        return repository.findById(id);
    }

    private void updateCustomRecord(CustomRecord customRecord, CustomRecordDTO customRecordDTO) {
        customRecord.setDescription(customRecordDTO.getDescription());
        customRecord.setValue(customRecordDTO.getValue());
        customRecord.setDate(customRecordDTO.getDate());
    }

    private void deleteById(Long id) {
        repository.deleteById(id);
    }

    private CustomRecord mapToEntity(CustomRecordDTO customRecordDTO) {
        return mapper.mapToEntity(customRecordDTO);
    }

    private CustomRecordDTO mapToDTO(CustomRecord customRecord) {
        return mapper.mapToDTO(customRecord);
    }

    private List<CustomRecordDTO> mapToDTOs(List<CustomRecord> list) {
        return mapper.mapToDTOs(list);
    }
}
