package codeenthusiast.TrainingCenterApp.services;

import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordDTO;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecord;
import codeenthusiast.TrainingCenterApp.constants.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.constants.WeightUnit;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordService;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(SpringExtension.class)
class StrengthRecordServiceTest {

    ModelMapper modelMapper;

    LocalDate currentDate = LocalDate.now();

    StrengthRecord squatRM;
    StrengthRecord deadlift1;
    StrengthRecord deadlift2;
    List<StrengthRecord> deadliftOneRepRecords;

    StrengthRecord benchPress3RM;
    StrengthRecordDTO deadliftRM;
    List<StrengthRecord> strengthRecords;

    @Mock
    StrengthRecordRepository strengthRecordRepository;

    StrengthRecordService strengthRecordService;

    @BeforeEach
    void setUp() {

        modelMapper = new ModelMapper();
        currentDate = LocalDate.now();

        squatRM = new StrengthRecord("Squat", WeightUnit.KILOGRAMS,
                150, RepetitionUnit.MOTION, 1, currentDate);
        benchPress3RM = new StrengthRecord("Bench press", WeightUnit.KILOGRAMS,
                100, RepetitionUnit.MOTION, 3, currentDate.minusDays(3));
        deadliftRM = new StrengthRecordDTO("Deadlift", WeightUnit.KILOGRAMS,
                100, RepetitionUnit.MOTION, 1, currentDate.minusDays(5));
        deadlift1 = new StrengthRecord("Deadlift", WeightUnit.KILOGRAMS, 150,
                RepetitionUnit.MOTION, 1, currentDate.minusDays(2));
        deadlift2 = new StrengthRecord("Deadlift", WeightUnit.KILOGRAMS, 160,
                RepetitionUnit.MOTION, 1, currentDate.minusDays(2));

        deadliftOneRepRecords = Arrays.asList(deadlift1, deadlift2);
        strengthRecords = Arrays.asList(squatRM, benchPress3RM);

        strengthRecordService = new StrengthRecordService(strengthRecordRepository);
    }

    @Test
    @DisplayName("Check if mapping is correctly done")
    void shouldMapToRecordDTO() {
        //given + when
        StrengthRecordDTO result = strengthRecordService.mapToStrengthRecordDTO(squatRM);

        //then
        assertAll(
                () -> assertThat(result, not(hasProperty("id"))),
                () -> assertThat(result.getExerciseName(), equalTo(squatRM.getExerciseName())),
                () -> assertThat(result.getSetDate(), equalTo(squatRM.getSetDate())));
    }

    @Test
    @DisplayName("Check if list of records is correctly mapped")
    void mapToListOfStrengthDTOs() {
        //given + when
        List<StrengthRecordDTO> result = strengthRecordService.mapToListOfStrengthDTOs(strengthRecords);

        //then
        assertAll(
                () -> assertThat(result.size(), equalTo(strengthRecords.size())),
                () -> assertThat(result.get(0).getExerciseName(), equalTo(strengthRecords.get(0).getExerciseName())),
                () -> assertThat(result.get(1), not(hasProperty("id"))));
    }


    @Test
    @DisplayName("Check if all records is returned and mapped to DTO")
    void shouldReturnAllRecords() {
        //given

        given(strengthRecordRepository.findAll()).willReturn(strengthRecords);

        //when
        List<StrengthRecordDTO> result = strengthRecordService.getAllStrengthRecords();

        //then
        assertAll(
                () -> assertThat(result.size(), equalTo(strengthRecords.size())),
                () -> assertThat(result.get(0), not(hasProperty("id"))),
                () -> assertThat(result.get(1).getExerciseName(), equalTo("Bench press")));
    }

    @Test
    @DisplayName("Check if all records is for given exercise returned and mapped to DTO")
    void shouldReturnAllRecordsForGivenExercise() {
        //given
        StrengthRecord squat2 = new StrengthRecord("Squat", WeightUnit.KILOGRAMS, 150,
                RepetitionUnit.MOTION, 3, currentDate);
        List<StrengthRecord> squatRecords = Arrays.asList(squatRM, squat2);
        given(strengthRecordRepository.findByExerciseName("Squat")).willReturn(squatRecords);

        //when
        List<StrengthRecordDTO> result = strengthRecordService.getStrengthRecordsForExercise("Squat");

        //then
        assertAll(
                () -> assertThat(result.size(), equalTo(squatRecords.size())),
                () -> assertThat(result.get(0), not(hasProperty("id"))),
                () -> assertThat(result.get(1).getExerciseName(), equalTo("Squat")));
    }


    @Test
    @DisplayName("Check if new record is created")
    void shouldCreateNewStrengthRecord() {
        //given
        given(strengthRecordService.getRecordsWithSameNameAndRepetition(deadliftRM)).willReturn(deadliftOneRepRecords);

        //when
        StrengthRecordDTO result = strengthRecordService.createNewRecord(new StrengthRecordDTO("Deadlift", WeightUnit.KILOGRAMS, 170,
                RepetitionUnit.MOTION, 1, currentDate));

        //then
        assertAll(
                () -> verify(strengthRecordRepository, times(1)).save(ArgumentMatchers.any()),
                () -> assertThat(result.getExerciseName(), equalTo("Deadlift")),
                () -> assertThat(result.getWeight(), equalTo(170)));

    }

    @Test
    @DisplayName("Check if entities with correct name and repetition are returned")
    void shouldReturnRecordsWithTheSameNameAndRepetition() {
        //given
        given(strengthRecordRepository.findByExerciseNameAndRepetition("Deadlift", 1)).willReturn(deadliftOneRepRecords);

        //when
        List<StrengthRecord> result = strengthRecordService.getRecordsWithSameNameAndRepetition(deadliftRM);

        //then
        assertThat(result, equalTo(deadliftOneRepRecords));
    }

    @Test
    @DisplayName("Check if highest record value is returned")
    void shouldReturnHighestValue() {
        //given + when
        int result = strengthRecordService.findHighestPreviousRecordValue(deadliftOneRepRecords);

        //then
        assertThat(result, equalTo(deadlift2.getWeight()));
    }

    @Test
    @DisplayName("Check if exception is thrown when new record value is less than previous")
    void shouldThrowExceptionWHenNewRecordValueIsLessThanPrevious() {
        //given + when
        int highestPreviousRecord = 200;
        StrengthRecordDTO newRecord = modelMapper.map(deadlift2, StrengthRecordDTO.class);

        //then
        assertThrows(IllegalArgumentException.class, () ->
                strengthRecordService.checkNewRecordSuperiority(newRecord, highestPreviousRecord));

    }

    @Test
    @DisplayName("Check if given record is deleted")
    void shouldDeleteRecord() {
        //given + when
        strengthRecordService.deleteRecord("Squat", 150, 1);

        //then
        verify(strengthRecordRepository, times(1)).deleteByExerciseNameAndWeightAndRepetition("Squat", 150, 1);
    }

}