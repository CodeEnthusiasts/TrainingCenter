package codeenthusiast.TrainingCenterApp.trainingsession;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseMapper;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseRepository;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExerciseServiceImpl;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details.StrengthExerciseDetails;
import codeenthusiast.TrainingCenterApp.movement.MovementServiceImpl;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanMapper;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlanServiceImpl;
import codeenthusiast.TrainingCenterApp.user.major.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@ExtendWith(SpringExtension.class)
class TrainingSessionServiceImplTest {

    private StrengthExercise strengthExerciseOne;

    private StrengthExercise strengthExerciseTwo;

    private List<StrengthExercise> strengthExercises;

    private TrainingSession trainingSession;

    private TrainingPlan trainingPlan;

    private User user;

    @Mock
    private TrainingSessionRepository trainingSessionRepository;

    @Mock
    private MovementServiceImpl movementService;

    @Mock
    private TrainingSessionMapper trainingSessionMapper;

    @Mock
    private TrainingPlanServiceImpl trainingPlanService;

    private TrainingSessionServiceImpl trainingSessionService;


    @BeforeEach
    void setUp() {

        trainingSessionService = new TrainingSessionServiceImpl(trainingSessionRepository,
                trainingSessionMapper, trainingPlanService);

        user = new User("John", "Lennon", "mail.dat@o2.pl");

        user.getUserDetails().setWeight(90);
        user.setId(1L);

        trainingPlan = new TrainingPlan(null, null, (short) 0, (short) 0, null, null, null, user, null, null);

        strengthExerciseOne = new StrengthExercise(RepetitionUnit.MOTION, (short) 10, WeightUnit.KILOGRAMS, 100,
                new StrengthExerciseDetails(), trainingSession);

        strengthExerciseTwo = new StrengthExercise(RepetitionUnit.MOTION, (short) 6, WeightUnit.KILOGRAMS, 125,
                new StrengthExerciseDetails(), trainingSession);

        strengthExerciseOne.setId(1L);
        strengthExerciseOne.setId(2L);

        strengthExercises = Arrays.asList(strengthExerciseOne, strengthExerciseTwo);

        trainingSession = new TrainingSession(null, strengthExercises, null, null, null,
                null, null, null, null, null, trainingPlan);
        trainingSession.setId(1L);
    }

    @Test
    @WithMockUser(value = "test_user")
    public void shouldCalculateTonnageIfStrengthExercisesAreCorrect(){
        //given
        given(trainingSessionRepository.findById(1L)).willReturn(Optional.of(trainingSession));
        given(trainingSessionRepository.findAllStrengthExecisesBySessionId(1L)).willReturn(strengthExercises);
        double result = 0;
        for(StrengthExercise element : strengthExercises){
            result += (element.getReps() * element.getWeight());
        }
        //when
        short tonnage = trainingSessionService.calculateTonnage(1L);

        //then
        assertEquals(tonnage, result);
    }

    @Test
    @WithMockUser(value = "test_user")
    public void shouldReturnZeroIfTrainingSessionDoesNotHaveAnyStrengthExercise(){
        //given
        given(trainingSessionRepository.findAllStrengthExecisesBySessionId(1L)).willReturn(Collections.emptyList());

        //when
        short tonnage = trainingSessionService.calculateTonnage(1L);

        //then
        assertEquals(tonnage, 0);
    }

    @Test
    @WithMockUser(value = "test_user")
    public void shouldNotCountTonnageWhenRepetitionUnitIsTime(){
        //given
        StrengthExercise s1 = new StrengthExercise(RepetitionUnit.TIME, (short) 60, WeightUnit.BODYWEIGHT, 0, null, trainingSession);
        StrengthExercise s2 = new StrengthExercise(RepetitionUnit.MOTION, (short) 15, WeightUnit.BODYWEIGHT, 0, null, trainingSession);
        List<StrengthExercise> customList = Arrays.asList(s1, s2);
        trainingSession.setStrengthExercises(customList);

        given(trainingSessionRepository.findById(1L)).willReturn(Optional.of(trainingSession));

        //when
        short tonnage = trainingSessionService.calculateTonnage(1L);

        //then
        assertEquals(tonnage, s2.getReps() * user.getUserDetails().getWeight());
    }


}