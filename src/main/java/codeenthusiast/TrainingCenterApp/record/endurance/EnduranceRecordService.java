package codeenthusiast.TrainingCenterApp.record.endurance;

import java.util.List;

public interface EnduranceRecordService {

    EnduranceRecord getEnduranceRecordEntityById(Long id);

    EnduranceRecordDTO createEnduranceRecord(Long personalRecordsId, EnduranceRecordDTO enduranceRecordDTO);

    EnduranceRecordDTO updateEnduranceRecord(Long enduranceRecordId, EnduranceRecordDTO enduranceRecordDTO);

    List<EnduranceRecordDTO> getAllEnduranceRecordsByPersonalRecordsId(Long id);

    List<EnduranceRecordDTO> getThreeLatestEnduranceRecordsByPersonalRecordsId(Long id);

    String deleteEnduranceRecord(Long id);

}
