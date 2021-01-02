package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StrengthRecordServiceImpl implements StrengthRecordService, SecurityService {

    private final StrengthRecordRepository repository;

    private final StrengthRecordMapper mapper;

    private final PersonalRecordsServiceImpl personalRecordsService;

    public StrengthRecordServiceImpl(StrengthRecordRepository repository,
                                     StrengthRecordMapper mapper,
                                     PersonalRecordsServiceImpl personalRecordsService) {
        this.repository = repository;
        this.mapper = mapper;
        this.personalRecordsService = personalRecordsService;
    }

    @Override
    public StrengthRecord getStrengthRecordEntityById(Long id) {
        StrengthRecord strengthRecord = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(strengthRecord));
        return strengthRecord;
    }

    @Override
    @Transactional
    public StrengthRecordDTO createStrengthRecord(Long personalRecordsId, StrengthRecordDTO strengthRecordDTO) {
        PersonalRecords personalRecords = personalRecordsService.getPersonalRecordsByUserId(personalRecordsId);
        StrengthRecord strengthRecord = mapToEntity(strengthRecordDTO);
        strengthRecord.setPersonalRecords(personalRecords);
        return mapToDTO(save(strengthRecord));
    }

    @Override
    @Transactional
    public StrengthRecordDTO updateStrengthRecord(Long strengthRecordId, StrengthRecordDTO strengthRecordDTO) {
        StrengthRecord strengthRecord = getStrengthRecordEntityById(strengthRecordId);
        updateStrengthRecord(strengthRecord, strengthRecordDTO);
        return mapToDTO(strengthRecord);
    }

    @Override
    public List<StrengthRecordDTO> getAllStrengthRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsService.getPersonalRecordsEntityById(personalRecordsId);
        return mapToDTOs(personalRecords.getStrengthRecords());
    }

    @Override
    public List<StrengthRecordDTO> getThreeLatestStrengthRecordsByPersonalRecordsId(Long personalRecordsId) {
        personalRecordsService.getPersonalRecordsEntityById(personalRecordsId);
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public String deleteStrengthRecord(Long strengthRecordId) {
        repository.delete(getStrengthRecordEntityById(strengthRecordId));
        return "Record deleted successfully. ";
    }

    private boolean hasAccess(StrengthRecord strengthRecord) {
        return strengthRecord.getPersonalRecords().getUser().getId().equals(getPrincipalId());
    }

    private StrengthRecord save(StrengthRecord strengthRecord) {
        return repository.save(strengthRecord);
    }

    private void updateStrengthRecord(StrengthRecord strengthRecord, StrengthRecordDTO strengthRecordDTO) {
        strengthRecord.setMovementName(strengthRecordDTO.getMovementName());
        strengthRecord.setWeightUnit(strengthRecordDTO.getWeightUnit());
        strengthRecord.setWeight(strengthRecordDTO.getWeight());
        strengthRecord.setRepetitionUnit(strengthRecordDTO.getRepetitionUnit());
        strengthRecord.setReps(strengthRecordDTO.getReps());
        strengthRecord.setDate(strengthRecordDTO.getDate());
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

