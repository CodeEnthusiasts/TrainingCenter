package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecordDTO;

import java.util.List;

public interface CustomRecordService {

    CustomRecordDTO createCustomRecord(Long personalRecordsId, CustomRecordDTO customRecordDTO);

    CustomRecordDTO updateCustomRecord(Long customRecordId, CustomRecordDTO customRecordDTO);

    List<CustomRecordDTO> getAllCustomRecordsByPersonalRecordsId(Long id);

    List<CustomRecordDTO> getThreeLatestCustomRecordsByPersonalRecordsId(Long id);

    String deleteCustomRecord(Long id);

}
