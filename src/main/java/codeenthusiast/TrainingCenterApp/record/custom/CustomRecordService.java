package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyExistsException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomRecordService {

    private ModelMapper modelMapper = new ModelMapper();

    private CustomRecordRepository customRecordRepository;

    public CustomRecordService(CustomRecordRepository customRecordRepository) {
        this.customRecordRepository = customRecordRepository;
    }

    public CustomRecordDTO mapToCustomRecordDTO(CustomRecord customRecord) {
        return modelMapper.map(customRecord, CustomRecordDTO.class);
    }

    public List<CustomRecordDTO> mapToListOfCustomRecordDTOs(List<CustomRecord> customRecords) {
        return customRecords.stream()
                .map(this::mapToCustomRecordDTO)
                .collect(Collectors.toList());
    }

    public List<CustomRecordDTO> getAllCustomRecords() {
        List<CustomRecord> customRecords = customRecordRepository.findAll();
        return mapToListOfCustomRecordDTOs(customRecords);
    }

    public CustomRecordDTO getCustomRecord(String description) {
        CustomRecord customRecord = customRecordRepository.findByDescription(description).orElseThrow(
                () -> new EntityNotFoundException(description));
        return mapToCustomRecordDTO(customRecord);
    }

    public CustomRecordDTO createNewRecord(CustomRecordDTO customRecord) {
        validateNewRecord(customRecord);
        CustomRecord newRecord = new CustomRecord(customRecord);
        customRecordRepository.save(newRecord);
        return mapToCustomRecordDTO(newRecord);
    }

    void validateNewRecord(CustomRecordDTO customRecord) {
        String description = customRecord.getDescription();
        if (customRecordRepository.existsByDescription(description)) {
            throw new EntityAlreadyExistsException(description);
        }
    }

    public void deleteCustomRecord(String description) {
        if (!customRecordRepository.existsByDescription(description)) {
            throw new EntityNotFoundException(description);
        }
        customRecordRepository.deleteByDescription(description);
    }


}
