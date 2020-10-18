package codeenthusiast.TrainingCenterApp.services;

import codeenthusiast.TrainingCenterApp.dto.CustomRecordDTO;
import codeenthusiast.TrainingCenterApp.entities.records.CustomRecord;
import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyFoundException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.repositories.CustomRecordRepository;
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
            throw new EntityAlreadyFoundException(description);
        }
    }

    public void deleteCustomRecord(String description) {
        if (!customRecordRepository.existsByDescription(description)) {
            throw new EntityNotFoundException(description);
        }
        customRecordRepository.deleteByDescription(description);
    }


}
