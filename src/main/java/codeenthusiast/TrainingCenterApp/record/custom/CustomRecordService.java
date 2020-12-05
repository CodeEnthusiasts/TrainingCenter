package codeenthusiast.TrainingCenterApp.record.custom;

import java.util.List;

public interface CustomRecordService {

    CustomRecord getCustomRecordEntityById(Long id);

    CustomRecordDTO createCustomRecord(Long personalRecordsId, CustomRecordDTO customRecordDTO);

    CustomRecordDTO updateCustomRecord(Long customRecordId, CustomRecordDTO customRecordDTO);

    List<CustomRecordDTO> getAllCustomRecordsByPersonalRecordsId(Long id);

    List<CustomRecordDTO> getThreeLatestCustomRecordsByPersonalRecordsId(Long id);

    String deleteCustomRecord(Long id);

}
