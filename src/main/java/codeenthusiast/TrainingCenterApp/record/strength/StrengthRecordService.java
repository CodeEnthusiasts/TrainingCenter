package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface StrengthRecordService extends AbstractService<StrengthRecord, StrengthRecordDTO> {

    String deleteById(Long id);

    List<StrengthRecordDTO> getAllStrengthRecordsByPersonalRecordsId(Long id);

    List<StrengthRecordDTO> getThreeLatestStrengthRecordsByPersonalRecordsId(Long id);

}
