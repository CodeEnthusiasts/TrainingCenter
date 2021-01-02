package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnduranceRecordServiceImpl implements EnduranceRecordService, SecurityService {

    private final EnduranceRecordRepository repository;

    private final EnduranceRecordMapper mapper;

    private final PersonalRecordsServiceImpl personalRecordsService;

    public EnduranceRecordServiceImpl(EnduranceRecordRepository repository,
                                      EnduranceRecordMapper mapper,
                                      PersonalRecordsServiceImpl personalRecordsService) {
        this.repository = repository;
        this.mapper = mapper;
        this.personalRecordsService = personalRecordsService;
    }

    @Override
    public EnduranceRecord getEnduranceRecordEntityById(Long id) {
        EnduranceRecord enduranceRecord = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(enduranceRecord));
        return enduranceRecord;
    }

    @Override
    @Transactional
    public EnduranceRecordDTO createEnduranceRecord(Long personalRecordsId, EnduranceRecordDTO enduranceRecordDTO) {
        PersonalRecords personalRecords = personalRecordsService.getPersonalRecordsEntityById(personalRecordsId);
        EnduranceRecord enduranceRecord = mapToEntity(enduranceRecordDTO);
        enduranceRecord.setPersonalRecords(personalRecords);
        return mapToDTO(save(enduranceRecord));
    }

    @Override
    @Transactional
    public EnduranceRecordDTO updateEnduranceRecord(Long enduranceRecordId, EnduranceRecordDTO enduranceRecordDTO) {
        EnduranceRecord enduranceRecord = getEnduranceRecordEntityById(enduranceRecordId);
        updateEnduranceRecord(enduranceRecord, enduranceRecordDTO);
        return mapToDTO(enduranceRecord);
    }

    @Override
    public List<EnduranceRecordDTO> getAllEnduranceRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsService.getPersonalRecordsEntityById(personalRecordsId);
        return mapToDTOs(personalRecords.getEnduranceRecords());
    }

    @Override
    public List<EnduranceRecordDTO> getThreeLatestEnduranceRecordsByPersonalRecordsId(Long personalRecordsId) {
        personalRecordsService.getPersonalRecordsEntityById(personalRecordsId);
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public String deleteEnduranceRecord(Long enduranceRecordId) {
        repository.delete(getEnduranceRecordEntityById(enduranceRecordId));
        return "Record deleted successfully. ";
    }

    private boolean hasAccess(EnduranceRecord enduranceRecord) {
        return enduranceRecord.getPersonalRecords().getUser().getId().equals(getPrincipalId());
    }

    private EnduranceRecord save(EnduranceRecord enduranceRecord) {
        return repository.save(enduranceRecord);
    }

    private void updateEnduranceRecord(EnduranceRecord enduranceRecord, EnduranceRecordDTO enduranceRecordDTO) {
        enduranceRecord.setMovementName(enduranceRecordDTO.getMovementName());
        enduranceRecord.setDistanceUnit(enduranceRecordDTO.getDistanceUnit());
        enduranceRecord.setDistance(enduranceRecordDTO.getDistance());
        enduranceRecord.setTimeUnit(enduranceRecordDTO.getTimeUnit());
        enduranceRecord.setDuration(enduranceRecordDTO.getDuration());
        enduranceRecord.setDate(enduranceRecordDTO.getDate());
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
