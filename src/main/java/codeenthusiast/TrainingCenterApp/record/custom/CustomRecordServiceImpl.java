package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.record.PersonalRecordsServiceImpl;
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
        CustomRecord customRecord = mapToEntity(customRecordDTO);
        customRecord.setPersonalRecords(personalRecordsServiceImpl.getPersonalRecordsByUserId(personalRecordsId));
        return mapToDTO(save(customRecord));
    }

    @Override
    public CustomRecordDTO updateCustomRecord(Long customRecordId, CustomRecordDTO customRecordDTO) {
        CustomRecord customRecord = getCustomRecordByIdFromRepo(customRecordId);
        updateCustomRecord(customRecord, customRecordDTO);
        return mapToDTO(save(customRecord));
    }

    @Override
    public List<CustomRecordDTO> getAllCustomRecordsByPersonalRecordsId(Long id) {
        return mapToDTOs(repository.findAllByPersonalRecordsId(id));
    }

    @Override
    public List<CustomRecordDTO> getThreeLatestCustomRecordsByPersonalRecordsId(Long id) {
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(id));
    }

    @Override
    public String deleteCustomRecord(Long id) {
        deleteById(id);
        return "Record deleted successfully. ";
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
