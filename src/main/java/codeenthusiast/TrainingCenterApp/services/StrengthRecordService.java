package codeenthusiast.TrainingCenterApp.services;

import codeenthusiast.TrainingCenterApp.dto.StrengthRecordDTO;
import codeenthusiast.TrainingCenterApp.entities.records.StrengthRecord;
import codeenthusiast.TrainingCenterApp.repositories.StrengthRecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StrengthRecordService {

    private ModelMapper modelMapper = new ModelMapper();

    private final StrengthRecordRepository strengthRecordRepository;

    public StrengthRecordService(StrengthRecordRepository strengthRecordRepository) {
        this.strengthRecordRepository = strengthRecordRepository;
    }

    public StrengthRecordDTO mapToStrengthRecordDTO(StrengthRecord strengthRecord) {
        return modelMapper.map(strengthRecord, StrengthRecordDTO.class);
    }

    public List<StrengthRecordDTO> mapToListOfStrengthDTOs(List<StrengthRecord> strengthRecords) {
        return strengthRecords.stream()
                .map(this::mapToStrengthRecordDTO)
                .collect(Collectors.toList());
    }

    public List<StrengthRecordDTO> getAllStrengthRecords() {
        List<StrengthRecord> strengthRecords = strengthRecordRepository.findAll();
        return mapToListOfStrengthDTOs(strengthRecords);
    }

    public List<StrengthRecordDTO> getStrengthRecordsForExercise(String exerciseName) {
        List<StrengthRecord> strengthRecordsForSingleExercise =
                strengthRecordRepository.findByExerciseName(exerciseName);
        return mapToListOfStrengthDTOs(strengthRecordsForSingleExercise);
    }

    public StrengthRecordDTO createNewRecord(StrengthRecordDTO strengthRecord){
        validateStrengthRecord(strengthRecord);
        StrengthRecord newRecord = new StrengthRecord(strengthRecord);
        strengthRecordRepository.save(newRecord);
        return strengthRecord;
    }

    void validateStrengthRecord(StrengthRecordDTO strengthRecord) {
        List<StrengthRecord> otherRecords = getRecordsWithSameNameAndRepetition(strengthRecord);
        if(otherRecords.size() != 0) {
            int highestPreviousRecord = findHighestPreviousRecordValue(otherRecords);
            checkNewRecordSuperiority(strengthRecord, highestPreviousRecord);
        }
    }

    List<StrengthRecord> getRecordsWithSameNameAndRepetition(StrengthRecordDTO strengthRecord) {
        return strengthRecordRepository
                .findByExerciseNameAndRepetition(strengthRecord.getExerciseName(), strengthRecord.getRepetition());
    }

    int findHighestPreviousRecordValue(List<StrengthRecord> otherRecords) {
         return otherRecords.stream()
                            .map(StrengthRecord::getWeight)
                            .max(Comparator.comparingInt(Integer::intValue)).get();
    }

    void checkNewRecordSuperiority(StrengthRecordDTO strengthRecord, int highestPreviousRecord) {
        if(highestPreviousRecord > strengthRecord.getWeight()){
            throw new IllegalArgumentException("New record cannot be less than previous highest record. " +
                    "Delete previous record or set the new one, greater than current");
        }
    }

    public void deleteRecord(String exerciseName, int weight, int repetition){
        strengthRecordRepository
                .deleteByExerciseNameAndWeightAndRepetition(exerciseName, weight, repetition);
    }
}
