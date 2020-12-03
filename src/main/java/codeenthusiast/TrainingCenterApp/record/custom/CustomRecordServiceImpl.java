package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.abstracts.SecurityService;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import org.springframework.stereotype.Service;

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
    public CustomRecordDTO createCustomRecord(Long personalRecordsId, CustomRecordDTO customRecordDTO) {
        PersonalRecords personalRecords = personalRecordsService.getPersonalRecordsById(personalRecordsId);
        authorize(personalRecordsService.hasAccess(personalRecords));
        CustomRecord customRecord = mapToEntity(customRecordDTO);
        customRecord.setPersonalRecords(personalRecords);
        return mapToDTO(save(customRecord));
    }

    @Override
    public CustomRecordDTO updateCustomRecord(Long customRecordId, CustomRecordDTO customRecordDTO) {
        CustomRecord customRecord = getNotNullCustomRecordByIdFromRepo(customRecordId);
        authorize(hasAccess(customRecord));
        updateCustomRecord(customRecord, customRecordDTO);
        return mapToDTO(save(customRecord));
    }

    @Override
    public List<CustomRecordDTO> getAllCustomRecordsByPersonalRecordsId(Long personalRecordsId) {
        authorize(personalRecordsService.hasAccess(personalRecordsService.getPersonalRecordsById(personalRecordsId)));
        return mapToDTOs(repository.findAllByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public List<CustomRecordDTO> getThreeLatestCustomRecordsByPersonalRecordsId(Long personalRecordsId) {
        authorize(personalRecordsService.hasAccess(personalRecordsService.getPersonalRecordsById(personalRecordsId)));
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(personalRecordsId));
    }

    @Override
    public String deleteCustomRecord(Long customRecordId) {
        authorize(hasAccess(getNotNullCustomRecordByIdFromRepo(customRecordId)));
        deleteById(customRecordId);
        return "Record deleted successfully. ";
    }

    private boolean hasAccess(CustomRecord customRecord) {
        UserDetailsImpl userDetailsImpl = getPrincipal();
        return customRecord.getPersonalRecords().getUser().getId().equals(userDetailsImpl.getId());
    }

    private CustomRecord save(CustomRecord customRecord) {
        return repository.save(customRecord);
    }

    private CustomRecord getNotNullCustomRecordByIdFromRepo(long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
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
