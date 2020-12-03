package codeenthusiast.TrainingCenterApp.record.endurance;

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
public class EnduranceRecordServiceImpl implements EnduranceRecordService {

    private final EnduranceRecordRepository repository;

    private final EnduranceRecordMapper mapper;

    private final PersonalRecordsServiceImpl personalRecordsServiceImpl;

    public EnduranceRecordServiceImpl(EnduranceRecordRepository repository,
                                      EnduranceRecordMapper mapper,
                                      PersonalRecordsServiceImpl personalRecordsServiceImpl) {
        this.repository = repository;
        this.mapper = mapper;
        this.personalRecordsServiceImpl = personalRecordsServiceImpl;
    }

    @Override
    public EnduranceRecordDTO createEnduranceRecord(Long personalRecordsId, EnduranceRecordDTO enduranceRecordDTO) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId);
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        EnduranceRecord enduranceRecord = mapToEntity(enduranceRecordDTO);
        enduranceRecord.setPersonalRecords(personalRecords);
        return mapToDTO(save(enduranceRecord));
    }

    @Override
    public EnduranceRecordDTO updateEnduranceRecord(Long enduranceRecordId, EnduranceRecordDTO enduranceRecordDTO) {
        EnduranceRecord enduranceRecord = getNotNullEnduranceRecordByIdFromRepo(enduranceRecordId);
        if(!hasAccess(enduranceRecord))
            throw new AccessDeniedException("Access denied");
        updateEnduranceRecord(enduranceRecord, enduranceRecordDTO);
        return mapToDTO(save(enduranceRecord));
    }

    @Override
    public List<EnduranceRecordDTO> getAllEnduranceRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId);
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        return mapToDTOs(repository.findAllByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public List<EnduranceRecordDTO> getThreeLatestEnduranceRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId);
        if(!personalRecordsServiceImpl.hasAccess(personalRecords))
            throw new AccessDeniedException("Access denied");
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public String deleteEnduranceRecord(Long enduranceRecordId) {
        EnduranceRecord enduranceRecord = getNotNullEnduranceRecordByIdFromRepo(enduranceRecordId);;
        if(!hasAccess(enduranceRecord))
            throw new AccessDeniedException("Access denied");
        deleteById(enduranceRecordId);
        return "Record deleted successfully. ";
    }

    private boolean hasAccess(EnduranceRecord enduranceRecord) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        return enduranceRecord.getPersonalRecords().getUser().getId().equals(userDetailsImpl.getId());
    }

    private EnduranceRecord save(EnduranceRecord enduranceRecord) {
        return repository.save(enduranceRecord);
    }

    private EnduranceRecord getNotNullEnduranceRecordByIdFromRepo(long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    private void updateEnduranceRecord(EnduranceRecord enduranceRecord, EnduranceRecordDTO enduranceRecordDTO) {
        enduranceRecord.setMovementName(enduranceRecordDTO.getMovementName());
        enduranceRecord.setDistanceUnit(enduranceRecordDTO.getDistanceUnit());
        enduranceRecord.setDistance(enduranceRecordDTO.getDistance());
        enduranceRecord.setTimeUnit(enduranceRecordDTO.getTimeUnit());
        enduranceRecord.setDuration(enduranceRecordDTO.getDuration());
        enduranceRecord.setDate(enduranceRecordDTO.getDate());
    }

    private void deleteById(Long id) {
        repository.deleteById(id);
    }

    private EnduranceRecord mapToEntity(EnduranceRecordDTO enduranceRecordDTO) {
        return mapper.mapToEntity(enduranceRecordDTO);
    }

    private EnduranceRecordDTO mapToDTO(EnduranceRecord enduranceRecord) {
        return mapper.mapToDTO(enduranceRecord);
    }

    private List<EnduranceRecordDTO> mapToDTOs(List<EnduranceRecord> list) {
        return mapper.mapToDTOs(list);
    }
}
