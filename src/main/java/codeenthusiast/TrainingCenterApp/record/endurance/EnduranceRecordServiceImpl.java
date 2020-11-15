package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.mappers.EnduranceRecordMapper;
import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
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
        EnduranceRecord enduranceRecord = mapToEntity(enduranceRecordDTO);
        enduranceRecord.setPersonalRecords(personalRecordsServiceImpl.getPersonalRecordsById(personalRecordsId));
        return mapToDTO(save(enduranceRecord));
    }

    @Override
    public EnduranceRecordDTO updateEnduranceRecord(Long enduranceRecordId, EnduranceRecordDTO enduranceRecordDTO) {
        EnduranceRecord enduranceRecord = getEnduranceRecordByIdFromRepo(enduranceRecordId);
        updateEnduranceRecord(enduranceRecord, enduranceRecordDTO);
        return mapToDTO(save(enduranceRecord));
    }

    @Override
    public List<EnduranceRecordDTO> getAllEnduranceRecordsByPersonalRecordsId(Long id) {
        return mapToDTOs(repository.findAllByPersonalRecordsId(id));
    }

    @Override
    public List<EnduranceRecordDTO> getThreeLatestEnduranceRecordsByPersonalRecordsId(Long id) {
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(id));
    }

    @Override
    public String deleteEnduranceRecord(Long id) {
        deleteById(id);
        return "Record deleted successfully. ";
    }

    private EnduranceRecord save(EnduranceRecord strengthRecord) {
        return repository.save(strengthRecord);
    }

    private EnduranceRecord getEnduranceRecordByIdFromRepo(long id) {
        return repository.findById(id);
    }

    private void updateEnduranceRecord(EnduranceRecord enduranceRecord, EnduranceRecordDTO enduranceRecordDTO) {
        enduranceRecord.setExerciseName(enduranceRecordDTO.getExerciseName());
        enduranceRecord.setDistanceUnit(enduranceRecordDTO.getDistanceUnit());
        enduranceRecord.setDistance(enduranceRecordDTO.getDistance());
        enduranceRecord.setTimeUnit(enduranceRecordDTO.getTimeUnit());
        enduranceRecord.setDuration(enduranceRecordDTO.getDuration());
        enduranceRecord.setSetDate(enduranceRecordDTO.getSetDate());
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
