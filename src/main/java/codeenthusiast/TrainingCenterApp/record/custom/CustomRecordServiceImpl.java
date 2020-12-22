package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomRecordServiceImpl implements CustomRecordService, SecurityService {

    private final CustomRecordRepository repository;

    private final CustomRecordMapper mapper;

    private final PersonalRecordsServiceImpl personalRecordsService;

    public CustomRecordServiceImpl(CustomRecordRepository repository,
                                   CustomRecordMapper mapper,
                                   PersonalRecordsServiceImpl personalRecordsService) {
        this.repository = repository;
        this.mapper = mapper;
        this.personalRecordsService = personalRecordsService;
    }

    @Override
    public CustomRecord getCustomRecordEntityById(Long id) {
        CustomRecord customRecord = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorize(hasAccess(customRecord));
        return customRecord;
    }

    @Override
    @Transactional
    public CustomRecordDTO createCustomRecord(Long personalRecordsId, CustomRecordDTO customRecordDTO) {
        PersonalRecords personalRecords = personalRecordsService.getPersonalRecordsEntityById(personalRecordsId);
        CustomRecord customRecord = mapToEntity(customRecordDTO);
        customRecord.setPersonalRecords(personalRecords);
        return mapToDTO(save(customRecord));
    }

    @Override
    @Transactional
    public CustomRecordDTO updateCustomRecord(Long customRecordId, CustomRecordDTO customRecordDTO) {
        CustomRecord customRecord = getCustomRecordEntityById(customRecordId);
        updateCustomRecord(customRecord, customRecordDTO);
        return mapToDTO(customRecord);
    }

    @Override
    public List<CustomRecordDTO> getAllCustomRecordsByPersonalRecordsId(Long personalRecordsId) {
        PersonalRecords personalRecords = personalRecordsService.getPersonalRecordsEntityById(personalRecordsId);
        return mapToDTOs(personalRecords.getCustomRecords());
    }

    @Override
    public List<CustomRecordDTO> getThreeLatestCustomRecordsByPersonalRecordsId(Long personalRecordsId) {
        personalRecordsService.getPersonalRecordsEntityById(personalRecordsId);
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public String deleteCustomRecord(Long customRecordId) {
        repository.delete(getCustomRecordEntityById(customRecordId));
        return "Record deleted successfully. ";
    }

    private boolean hasAccess(CustomRecord customRecord) {
        return customRecord.getPersonalRecords().getUser().getId().equals(getPrincipal().getId());
    }

    private CustomRecord save(CustomRecord customRecord) {
        return repository.save(customRecord);
    }

    private void updateCustomRecord(CustomRecord customRecord, CustomRecordDTO customRecordDTO) {
        customRecord.setDescription(customRecordDTO.getDescription());
        customRecord.setValue(customRecordDTO.getValue());
        customRecord.setDate(customRecordDTO.getDate());
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
