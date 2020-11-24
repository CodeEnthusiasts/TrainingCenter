package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordDTO;

import java.util.List;

public interface EnduranceRecordService {

    EnduranceRecordDTO createEnduranceRecord(Long personalRecordsId, EnduranceRecordDTO enduranceRecordDTO);

    EnduranceRecordDTO updateEnduranceRecord(Long enduranceRecordId, EnduranceRecordDTO enduranceRecordDTO);

    List<EnduranceRecordDTO> getAllEnduranceRecordsByPersonalRecordsId(Long id);

    List<EnduranceRecordDTO> getThreeLatestEnduranceRecordsByPersonalRecordsId(Long id);

    String deleteEnduranceRecord(Long id);

}
