package codeenthusiast.TrainingCenterApp.exercise.enduranceexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.EnduranceExerciseMapper;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class EnduranceExerciseServiceImpl extends AbstractServiceImpl<EnduranceExercise, EnduranceExerciseDTO>
        implements EnduranceExerciseService {

    private EnduranceRecordRepository enduranceRecordRepository;

    private EnduranceExerciseMapper enduranceExerciseMapper;

    public EnduranceExerciseServiceImpl(AbstractRepository<EnduranceExercise> repository, AbstractMapper<EnduranceExercise,
            EnduranceExerciseDTO> mapper, EnduranceRecordRepository enduranceRecordRepository, EnduranceExerciseMapper enduranceExerciseMapper) {
        super(repository, mapper);
        this.enduranceRecordRepository = enduranceRecordRepository;
        this.enduranceExerciseMapper = enduranceExerciseMapper;
    }
}
