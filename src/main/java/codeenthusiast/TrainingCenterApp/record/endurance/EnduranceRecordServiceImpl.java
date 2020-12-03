package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import org.springframework.stereotype.Service;

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
    public EnduranceRecordDTO createEnduranceRecord(Long personalRecordsId, EnduranceRecordDTO enduranceRecordDTO) {
        PersonalRecords personalRecords = personalRecordsService.getPersonalRecordsById(personalRecordsId);
        authorize(personalRecordsService.hasAccess(personalRecords));
        EnduranceRecord enduranceRecord = mapToEntity(enduranceRecordDTO);
        enduranceRecord.setPersonalRecords(personalRecords);
        return mapToDTO(save(enduranceRecord));
    }

    @Override
    public EnduranceRecordDTO updateEnduranceRecord(Long enduranceRecordId, EnduranceRecordDTO enduranceRecordDTO) {
        EnduranceRecord enduranceRecord = getNotNullEnduranceRecordByIdFromRepo(enduranceRecordId);
        authorize(hasAccess(enduranceRecord));
        updateEnduranceRecord(enduranceRecord, enduranceRecordDTO);
        return mapToDTO(save(enduranceRecord));
    }

    @Override
    public List<EnduranceRecordDTO> getAllEnduranceRecordsByPersonalRecordsId(Long personalRecordsId) {
        authorize(personalRecordsService.hasAccess(personalRecordsService.getPersonalRecordsById(personalRecordsId)));
        return mapToDTOs(repository.findAllByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public List<EnduranceRecordDTO> getThreeLatestEnduranceRecordsByPersonalRecordsId(Long personalRecordsId) {
        authorize(personalRecordsService.hasAccess(personalRecordsService.getPersonalRecordsById(personalRecordsId)));
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public String deleteEnduranceRecord(Long enduranceRecordId) {
        authorize(hasAccess(getNotNullEnduranceRecordByIdFromRepo(enduranceRecordId)));
        deleteById(enduranceRecordId);
        return "Record deleted successfully. ";
    }

    private boolean hasAccess(EnduranceRecord enduranceRecord) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
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
