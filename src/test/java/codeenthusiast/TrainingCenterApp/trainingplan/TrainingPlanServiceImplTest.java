package codeenthusiast.TrainingCenterApp.trainingplan;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.StrengthExercise;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details.StrengthExerciseDetails;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.user.major.User;
import codeenthusiast.TrainingCenterApp.user.major.UserServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class TrainingPlanServiceImplTest {

    @Mock
    private TrainingPlanRepository trainingPlanRepository;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private TrainingPlanMapper trainingPlanMapper;

    private TrainingPlanServiceImpl trainingPlanService;

    private StrengthExercise strengthExerciseOne;

    private StrengthExercise strengthExerciseTwo;

    private StrengthExercise strengthExerciseThree;

    private TrainingSession trainingSessionOne;

    private TrainingSession trainingSessionTwo;

    private List<TrainingSession> trainingSessionList;

    private User user;

    private TrainingPlan trainingPlan;

    @BeforeEach
    public void setUp() {
        user = new User("John", "Lennon", "mail.dat@o2.pl");

        user.getUserDetails().setWeight(90);
        user.setId(1L);


        strengthExerciseOne = new StrengthExercise(RepetitionUnit.MOTION, (short) 10, WeightUnit.KILOGRAMS, 100,
                new StrengthExerciseDetails(), trainingSessionOne);

        strengthExerciseTwo = new StrengthExercise(RepetitionUnit.MOTION, (short) 6, WeightUnit.KILOGRAMS, 125,
                new StrengthExerciseDetails(), trainingSessionOne);

        strengthExerciseThree = new StrengthExercise(RepetitionUnit.MOTION, (short) 3, WeightUnit.KILOGRAMS, 150,
                new StrengthExerciseDetails(), trainingSessionOne);

        trainingSessionOne = new TrainingSession(null, Arrays.asList(strengthExerciseOne, strengthExerciseTwo), null, null, null,
                null, null, null, null, null, trainingPlan);

        trainingSessionTwo = new TrainingSession(null, Collections.singletonList(strengthExerciseThree), null, null, null,
                null, null, null, null, null, trainingPlan);

        trainingSessionOne.setStrengthExercises(Arrays.asList(strengthExerciseOne, strengthExerciseTwo));
        trainingSessionTwo.setStrengthExercises(Collections.singletonList(strengthExerciseThree));

        trainingSessionList = Arrays.asList(trainingSessionOne, trainingSessionTwo);

        trainingPlan = new TrainingPlan(null, trainingSessionList, (short) 0, (short) 0, null, null, null, user, null, null);

        trainingPlanService = new TrainingPlanServiceImpl(trainingPlanRepository, trainingPlanMapper, userService);
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldCalculateTonnage() {
        //given
        given(trainingPlanRepository.findById(1L)).willReturn(Optional.of(trainingPlan));
        short t1 = (short) (strengthExerciseOne.getWeight() * strengthExerciseOne.getReps());
        short t2 = (short) (strengthExerciseTwo.getWeight() * strengthExerciseTwo.getReps());
        short t3 = (short) (strengthExerciseThree.getWeight() * strengthExerciseThree.getReps());
        short tonnage = (short) (t1 + t2 + t3);

        //when
        short result = trainingPlanService.calculateTonnage(1L);

        //then
        assertEquals(result, tonnage);
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldReturnZeroIsTrainingPlanIsEmpty() {
        //given
        given(trainingPlanRepository.findById(1L)).willReturn(Optional.of(trainingPlan));
        trainingPlan.setTrainingSessions(Collections.emptyList());

        //when
        short result = trainingPlanService.calculateTonnage(1L);

        //then
        assertEquals(result, 0);
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldNotCalculateExercisesWhenRepetitionUnitIsTime() {
        //given
        given(trainingPlanRepository.findById(1L)).willReturn(Optional.of(trainingPlan));
        TrainingSession trainingSession = trainingPlan.getTrainingSessions().get(1);
        trainingSession.getStrengthExercises().get(0).setRepetitionUnit(RepetitionUnit.TIME);

        short t1 = (short) (strengthExerciseOne.getWeight() * strengthExerciseOne.getReps());
        short t2 = (short) (strengthExerciseTwo.getWeight() * strengthExerciseTwo.getReps());

        short tonnage = (short) (t1 + t2);

        //when
        short result = trainingPlanService.calculateTonnage(1L);

        //then
        assertEquals(tonnage, result);
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldSetUserBodyWeightWhenWeightUnitIsBodyWeight() {
        //given
        given(trainingPlanRepository.findById(1L)).willReturn(Optional.of(trainingPlan));

        TrainingSession bodyWeightSession = new TrainingSession(null, null, null, null, null,
                null, null, null, null, null, trainingPlan);

        StrengthExercise bodyWeightExercise = new StrengthExercise(RepetitionUnit.MOTION, (short) 10, WeightUnit.BODYWEIGHT, 0, null, bodyWeightSession);
        bodyWeightSession.setStrengthExercises(Collections.singletonList(bodyWeightExercise));

        trainingPlan.setUser(user);
        trainingPlan.setTrainingSessions(Collections.singletonList(bodyWeightSession));

        short tonnage = (short) (user.getUserDetails().getWeight() * bodyWeightExercise.getReps());
        //when
        short result = trainingPlanService.calculateTonnage(1L);

        //then
        assertEquals(tonnage, result);
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldAddWeightToUserWeightWhenWeightUnitIsBodyWeightAndWeightIsGreaterThan0() {
        //given
        given(trainingPlanRepository.findById(1L)).willReturn(Optional.of(trainingPlan));

        TrainingSession bodyWeightSession = new TrainingSession(null, null, null, null, null,
                null, null, null, null, null, trainingPlan);

        StrengthExercise bodyWeightExercise = new StrengthExercise(RepetitionUnit.MOTION, (short) 10, WeightUnit.BODYWEIGHT, 10, null, bodyWeightSession);
        bodyWeightSession.setStrengthExercises(Collections.singletonList(bodyWeightExercise));

        trainingPlan.setTrainingSessions(Collections.singletonList(bodyWeightSession));

        short tonnage = (short) ((user.getUserDetails().getWeight() + bodyWeightExercise.getWeight()) * bodyWeightExercise.getReps());
        //when
        short result = trainingPlanService.calculateTonnage(1L);

        //then
        assertEquals(tonnage, result);
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldThrowAnErrorWhenWeightUnitIsBodyWeightAndUserWeightIs0() {
        //given + when
        given(trainingPlanRepository.findById(1L)).willReturn(Optional.of(trainingPlan));

        TrainingSession bodyWeightSession = new TrainingSession(null, null, null, null, null,
                null, null, null, null, null, trainingPlan);

        StrengthExercise bodyWeightExercise = new StrengthExercise(RepetitionUnit.MOTION, (short) 10, WeightUnit.BODYWEIGHT, 10, null, bodyWeightSession);
        bodyWeightSession.setStrengthExercises(Collections.singletonList(bodyWeightExercise));

        user.getUserDetails().setWeight(0);
        trainingPlan.setTrainingSessions(Collections.singletonList(bodyWeightSession));

        //then
        assertThrows(IllegalArgumentException.class,
                () -> trainingPlanService.calculateTonnage(1L));
    }
}