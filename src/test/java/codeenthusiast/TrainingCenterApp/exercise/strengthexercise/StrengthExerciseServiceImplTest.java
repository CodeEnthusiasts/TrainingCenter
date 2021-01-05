package codeenthusiast.TrainingCenterApp.exercise.strengthexercise;

import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.exercise.strengthexercise.details.StrengthExerciseDetails;
import codeenthusiast.TrainingCenterApp.movement.MovementServiceImpl;
import codeenthusiast.TrainingCenterApp.trainingplan.TrainingPlan;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSession;
import codeenthusiast.TrainingCenterApp.trainingsession.TrainingSessionServiceImpl;
import codeenthusiast.TrainingCenterApp.user.major.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class StrengthExerciseServiceImplTest {

    private StrengthExercise strengthExercise;

    private TrainingSession trainingSession;

    private TrainingPlan trainingPlan;

    private User user;

    @Mock
    private StrengthExerciseRepository strengthExerciseRepository;

    @Mock
    private TrainingSessionServiceImpl trainingSessionService;

    @Mock
    private MovementServiceImpl movementService;

    @Mock
    private StrengthExerciseMapper strengthExerciseMapper;

    private StrengthExerciseServiceImpl strengthExerciseService;


    @BeforeEach
    void setUp() {

        strengthExerciseService = new StrengthExerciseServiceImpl(strengthExerciseRepository,
                trainingSessionService, movementService, strengthExerciseMapper);

        user = new User("John", "Lennon", "mail.dat@o2.pl");

        user.getUserDetails().setWeight(90);
        user.setId(1L);

        trainingPlan = new TrainingPlan(null, null, (short) 0, (short) 0, null, null, null, user, null, null);

        trainingSession = new TrainingSession(null, null, null, null, null,
                null, null, null, null, null, trainingPlan);

        strengthExercise = new StrengthExercise(RepetitionUnit.MOTION, (short) 10, WeightUnit.KILOGRAMS, 100,
                new StrengthExerciseDetails(), trainingSession);

        strengthExercise.setId(1L);

    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldCalculateTonnageIfRepetitionUnitIsMotionAndWeightIsKilograms() {
        //given
        given(strengthExerciseRepository.findById(1L)).willReturn(Optional.of(strengthExercise));

        //when
        short tonnage = strengthExerciseService.calculateTonnage(1L);

        //then
        assertEquals(strengthExercise.getReps() * strengthExercise.getWeight(), tonnage);
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldThrowAnErrorIfRepetitionUnitIsMotionAndWeightEqualsToO() {
        //given + when
        strengthExercise.setWeight(0);
        given(strengthExerciseRepository.findById(1L)).willReturn(Optional.of(strengthExercise));

        //when
        assertThrows(IllegalArgumentException.class,
                () -> strengthExerciseService.calculateTonnage(1L));
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldThrowAnErrorIfRepetitionUnitIsMotionAndRepetitionEqualsToO() {
        //given + when
        strengthExercise.setReps((short) 0);
        given(strengthExerciseRepository.findById(1L)).willReturn(Optional.of(strengthExercise));

        //when
        assertThrows(IllegalArgumentException.class,
                () -> strengthExerciseService.calculateTonnage(1L));
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldCalculateTonnageAndSetUserWeightIfIsBiggerThan0AndWeightUnitIsBodyWeight() {
        //given
        strengthExercise.setWeightUnit(WeightUnit.BODYWEIGHT);
        given(strengthExerciseRepository.findById(1L)).willReturn(Optional.of(strengthExercise));

        //when
        short tonnage = strengthExerciseService.calculateTonnage(1L);

        //then
        assertEquals(tonnage, strengthExercise.getReps() * user.getUserDetails().getWeight());
    }

    @Test
    @WithMockUser(value = "test_user")
    void shouldThrowAnErrorWhenUserWeightIfBodyWeightIs0AndWeightUnitIsBodyWeight() {
        //given + when
        strengthExercise.setWeightUnit(WeightUnit.BODYWEIGHT);
        user.getUserDetails().setWeight(0);
        given(strengthExerciseRepository.findById(1L)).willReturn(Optional.of(strengthExercise));

        //then
        assertThrows(IllegalArgumentException.class,
                () -> strengthExerciseService.calculateTonnage(1L));
    }


}