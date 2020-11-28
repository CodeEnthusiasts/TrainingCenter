package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
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
        StrengthRecord strengthRecord = mapToEntity(strengthRecordDTO);
        strengthRecord.setPersonalRecords(personalRecordsServiceImpl.getPersonalRecordsByUserId(personalRecordsId));
        return mapToDTO(save(strengthRecord));
    }

    @Override
    public StrengthRecordDTO updateStrengthRecord(Long strengthRecordId, StrengthRecordDTO strengthRecordDTO) {
        StrengthRecord strengthRecord = getStrengthRecordByIdFromRepo(strengthRecordId);
        updateStrengthRecord(strengthRecord, strengthRecordDTO);
        return mapToDTO(save(strengthRecord));
    }

    @Override
    public List<StrengthRecordDTO> getAllStrengthRecordsByPersonalRecordsId(Long id) {
        return mapToDTOs(repository.findAllByPersonalRecordsId(id));
    }

    @Override
    public List<StrengthRecordDTO> getThreeLatestStrengthRecordsByPersonalRecordsId(Long id) {
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(id));
    }

    @Override
    public String deleteStrengthRecord(Long id) {
        deleteById(id);
        return "Record deleted successfully. ";
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
        strengthRecord.setWeight(strengthRecord.getWeight());
        strengthRecord.setRepetitionUnit(strengthRecord.getRepetitionUnit());
        strengthRecord.setReps(strengthRecord.getReps());
        strengthRecord.setDate(strengthRecord.getDate());
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

