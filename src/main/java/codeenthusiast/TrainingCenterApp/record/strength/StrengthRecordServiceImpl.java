package codeenthusiast.TrainingCenterApp.record.strength;

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
public class StrengthRecordServiceImpl implements StrengthRecordService {

    private final StrengthRecordRepository repository;

    private final StrengthRecordMapper mapper;

    private final PersonalRecordsServiceImpl personalRecordsServiceImpl;

    public StrengthRecordServiceImpl(StrengthRecordRepository repository,
                                     StrengthRecordMapper mapper,
                                     PersonalRecordsServiceImpl personalRecordsServiceImpl) {
        this.repository = repository;
        this.mapper = mapper;
        this.personalRecordsServiceImpl = personalRecordsServiceImpl;
    }

    @Override
    public StrengthRecordDTO createStrengthRecord(Long personalRecordsId, StrengthRecordDTO strengthRecordDTO) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsByUserId(personalRecordsId);
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        StrengthRecord strengthRecord = mapToEntity(strengthRecordDTO);
        strengthRecord.setPersonalRecords(personalRecords);
        return mapToDTO(save(strengthRecord));
    }

    @Override
    public StrengthRecordDTO updateStrengthRecord(Long strengthRecordId, StrengthRecordDTO strengthRecordDTO) {
        StrengthRecord strengthRecord = getStrengthRecordByIdFromRepo(strengthRecordId);
        if(isNull(strengthRecord))
            throw new EntityNotFoundException("Resource not available");
        if(!hasAccess(strengthRecord))
            throw new AccessDeniedException("Access denied");
        updateStrengthRecord(strengthRecord, strengthRecordDTO);
        return mapToDTO(save(strengthRecord));
    }

    @Override
    public List<StrengthRecordDTO> getAllStrengthRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId);
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        return mapToDTOs(repository.findAllByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public List<StrengthRecordDTO> getThreeLatestStrengthRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId);
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public String deleteStrengthRecord(Long strengthRecordId) {
        StrengthRecord strengthRecord = getStrengthRecordByIdFromRepo(strengthRecordId);
        if(isNull(strengthRecord))
            throw new EntityNotFoundException("Resource not available");
        if(!hasAccess(strengthRecord))
            throw new AccessDeniedException("Access denied");
        deleteById(strengthRecordId);
        return "Record deleted successfully. ";
    }

    private boolean hasAccess(StrengthRecord strengthRecord) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return strengthRecord.getPersonalRecords().getUser().getId().equals(userDetailsImpl.getId());
    }

    private UserDetailsImpl getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }

    private boolean isNull(StrengthRecord strengthRecord) {
        return strengthRecord == null;
    }

    private StrengthRecord save(StrengthRecord strengthRecord) {
        return repository.save(strengthRecord);
    }

    private StrengthRecord getStrengthRecordByIdFromRepo(long id) {
        return repository.findById(id);
    }

    private void updateStrengthRecord(StrengthRecord strengthRecord, StrengthRecordDTO strengthRecordDTO) {
        strengthRecord.setMovementName(strengthRecordDTO.getMovementName());
        strengthRecord.setWeightUnit(strengthRecordDTO.getWeightUnit());
        strengthRecord.setWeight(strengthRecordDTO.getWeight());
        strengthRecord.setRepetitionUnit(strengthRecordDTO.getRepetitionUnit());
        strengthRecord.setReps(strengthRecordDTO.getReps());
        strengthRecord.setDate(strengthRecordDTO.getDate());
    }

    private void deleteById(Long id) {
        repository.deleteById(id);
    }

    private StrengthRecord mapToEntity(StrengthRecordDTO strengthRecordDTO) {
        return mapper.mapToEntity(strengthRecordDTO);
    }

    private StrengthRecordDTO mapToDTO(StrengthRecord strengthRecord) {
        return mapper.mapToDTO(strengthRecord);
    }

    private List<StrengthRecordDTO> mapToDTOs(List<StrengthRecord> list) {
        return mapper.mapToDTOs(list);
    }
}

