package codeenthusiast.TrainingCenterApp.record.endurance;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnduranceRecordService {

//    private ModelMapper modelMapper = new ModelMapper();
//
//    private EnduranceRecordRepository enduranceRecordRepository;
//
//    public EnduranceRecordService(EnduranceRecordRepository enduranceRecordRepository) {
//        this.enduranceRecordRepository = enduranceRecordRepository;
//    }
//
//    public EnduranceRecordDTO mapToEnduranceRecordDTO(EnduranceRecord enduranceRecord) {
//        return modelMapper.map(enduranceRecord, EnduranceRecordDTO.class);
//    }
//
//    public List<EnduranceRecordDTO> mapToListOfEnduranceDTOs(List<EnduranceRecord> enduranceRecords) {
//        return enduranceRecords.stream()
//                .map(this::mapToEnduranceRecordDTO)
//                .collect(Collectors.toList());
//    }
//
//    public List<EnduranceRecordDTO> getAllStrengthRecords() {
//        List<EnduranceRecord> enduranceRecords = enduranceRecordRepository.findAll();
//        return mapToListOfEnduranceDTOs(enduranceRecords);
//    }
//
//    public List<EnduranceRecordDTO> getEnduranceRecordsForExercise(String exerciseName) {
//        List<EnduranceRecord> enduranceRecordsForSingleExercise =
//                enduranceRecordRepository.findByExerciseName(exerciseName);
//        return mapToListOfEnduranceDTOs(enduranceRecordsForSingleExercise);
//    }
//
////    public EnduranceRecordDTO createNewRecord(EnduranceRecordDTO enduranceRecord) {
////        validateEnduranceRecord(enduranceRecord);
////        EnduranceRecord newRecord = new EnduranceRecord(enduranceRecord);
////        enduranceRecordRepository.save(newRecord);
////        return enduranceRecord;
////    }
//
//    void validateEnduranceRecord(EnduranceRecordDTO enduranceRecord) {
//        List<EnduranceRecord> otherRecords = getRecordsWithSameNameAndTime(enduranceRecord);
//        if (otherRecords.size() != 0) {
//            int highestPreviousRecord = findHighestPreviousRecordValue(otherRecords);
//            checkNewRecordSuperiority(enduranceRecord, highestPreviousRecord);
//        }
//    }
//
//    public List<EnduranceRecord> getRecordsWithSameNameAndTime(EnduranceRecordDTO enduranceRecord) {
//        return enduranceRecordRepository
//                .findByExerciseNameAndTime(enduranceRecord.getExerciseName(), enduranceRecord.getTime());
//    }
//
////    public int findHighestPreviousRecordValue(List<EnduranceRecord> otherRecords) {
////        return otherRecords.stream()
////                .map(EnduranceRecord::)
////                .max(Comparator.comparingInt(Integer::intValue)).get();
////    }
//
//    public void checkNewRecordSuperiority(EnduranceRecordDTO enduranceRecord, int highestPreviousRecord) {
//        if (highestPreviousRecord < enduranceRecord.getTime()) {
//            throw new IllegalArgumentException("New record cannot be less than previous highest record. " +
//                    "Delete previous record or set the new one, greater than current");
//        }
//    }
//
//    public void deleteRecord(String exerciseName, int distance, int time) {
//        enduranceRecordRepository
//                .deleteByExerciseNameAndDistanceAndTime(exerciseName, distance, time);
//    }

}
