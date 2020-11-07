package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.Exercise;
import codeenthusiast.TrainingCenterApp.mappers.StrengthExerciseMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class StrengthExerciseServiceImpl extends AbstractServiceImpl<StrengthExercise, StrengthExerciseDTO>
        implements StrengthExerciseService {

    private StrengthExerciseRepository strengthExerciseRepository;

    private StrengthExerciseMapper strengthExerciseMapper;

    public StrengthExerciseServiceImpl(AbstractRepository<StrengthExercise> repository, AbstractMapper<StrengthExercise,
            StrengthExerciseDTO> mapper, StrengthExerciseRepository strengthExerciseRepository, StrengthExerciseMapper strengthExerciseMapper) {
        super(repository, mapper);
        this.strengthExerciseRepository = strengthExerciseRepository;
        this.strengthExerciseMapper = strengthExerciseMapper;
    }

//    @EventListener(ApplicationReadyEvent.class)
//     public void init(){
//        StrengthExercise s1 = new StrengthExercise(null, 3,  RepetitionUnit.MOTION, new int[]{10,10,10}, WeightUnit.KILOGRAMS,
//                new int[]{100, 100, 100}, null);
//
//        StrengthExercise s2 = new StrengthExercise(null, 4,  RepetitionUnit.MOTION, new int[]{8,8,8}, WeightUnit.KILOGRAMS,
//                new int[]{130, 135, 140, 156}, null);
//
//        StrengthExercise s3 = new StrengthExercise(null, 5,  RepetitionUnit.MOTION, new int[]{5,5,5}, WeightUnit.KILOGRAMS,
//                new int[]{150, 150, 150, 150, 150}, null);
//        StrengthExerciseDTO m1 = strengthExerciseMapper.mapToDTO(s1);
//        StrengthExerciseDTO m2 = strengthExerciseMapper.mapToDTO(s2);
//        StrengthExerciseDTO m3 = strengthExerciseMapper.mapToDTO(s3);
//        save(m1);
//        save(m2);
//        save(m3);
//    }

}
