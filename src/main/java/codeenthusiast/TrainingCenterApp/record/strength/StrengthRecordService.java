package codeenthusiast.TrainingCenterApp.record.strength;

import java.util.List;

public interface StrengthRecordService {

    StrengthRecord getStrengthRecordEntityById(Long id);

    StrengthRecordDTO createStrengthRecord(Long personalRecordsId, StrengthRecordDTO strengthRecordDTO);

    StrengthRecordDTO updateStrengthRecord(Long strengthRecordId, StrengthRecordDTO strengthRecordDTO);

    List<StrengthRecordDTO> getAllStrengthRecordsByPersonalRecordsId(Long id);

    List<StrengthRecordDTO> getThreeLatestStrengthRecordsByPersonalRecordsId(Long id);

    String deleteStrengthRecord(Long id);

}
