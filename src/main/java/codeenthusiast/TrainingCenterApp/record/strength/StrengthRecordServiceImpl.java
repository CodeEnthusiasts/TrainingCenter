package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.StrengthRecordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrengthRecordServiceImpl extends AbstractServiceImpl<StrengthRecord, StrengthRecordDTO>
        implements StrengthRecordService {

    private final StrengthRecordRepository repository;

    private final StrengthRecordMapper mapper;

    public StrengthRecordServiceImpl(AbstractRepository<StrengthRecord> repository,
                                     AbstractMapper<StrengthRecord, StrengthRecordDTO> mapper,
                                     StrengthRecordRepository repository1,
                                     StrengthRecordMapper mapper1) {
        super(repository, mapper);
        this.repository = repository1;
        this.mapper = mapper1;
    }

    @Override
    public List<StrengthRecordDTO> getAllStrengthRecordsByPersonalRecordsId(Long id) {
        return mapToDTOs(repository.findAllByPersonalRecordsId(id));
    }

    @Override
    public List<StrengthRecordDTO> getThreeLatestStrengthRecordsByPersonalRecordsId(Long id) {
        return mapToDTOs(repository.findThreeLatestByPersonalRecordsId(id));
    }

    @Override
    public String deleteById(Long id) {
        repository.deleteById(id);
        return "Record deleted successfully. ";
    }

    private List<StrengthRecordDTO> mapToDTOs(List<StrengthRecord> list) {
        return mapper.mapToDTOs(list);
    }

}

