package codeenthusiast.TrainingCenterApp.services;

import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordDTO;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecord;
import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyFoundException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordService;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordRepository;
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
class CustomRecordServiceTest {

    ModelMapper modelMapper;

    LocalDate current;

    CustomRecord recordI;

    CustomRecord recordII;

    List<CustomRecord> customRecords;

    CustomRecordDTO recordIII;

    CustomRecordDTO recordIV;

    @Mock
    CustomRecordRepository customRecordRepository;

    CustomRecordService customRecordService;

    @BeforeEach
    void setUp() {
        modelMapper = new ModelMapper();
        current = LocalDate.now();

        recordI = new CustomRecord("Powerlifting championship", 1.0,
                LocalDate.of(2016, 5, 5));
        recordII = new CustomRecord("Walking on the hands", 30.0, current);

        customRecords = Arrays.asList(recordI, recordII);

        recordIII = new CustomRecordDTO("Vertical jump", 0.5, current);
        recordIV = new CustomRecordDTO("Climb the mountain", 2500, current);

        customRecordService = new CustomRecordService(customRecordRepository);
    }

    @Test
    @DisplayName("Check if mapping is correctly done")
    void shouldMapToRecordDTO() {
        //given + when
        CustomRecordDTO result = customRecordService.mapToCustomRecordDTO(recordI);

        //then
        assertAll(
                () -> assertThat(result, not(hasProperty("id"))),
                () -> assertThat(result.getDescription(), equalTo(recordI.getDescription())),
                () -> assertThat(result.getSetDate(), equalTo(recordI.getSetDate())));
    }

    @Test
    @DisplayName("Check if list of records is correctly mapped")
    void shouldMapToListOfStrengthDTOs() {
        //given + when
        List<CustomRecordDTO> result = customRecordService.mapToListOfCustomRecordDTOs(customRecords);

        //then
        assertAll(
                () -> assertThat(result.size(), equalTo(customRecords.size())),
                () -> assertThat(result.get(0).getDescription(), equalTo(customRecords.get(0).getDescription())),
                () -> assertThat(result.get(1), not(hasProperty("id"))));
    }


    @Test
    @DisplayName("Check if all records is returned and mapped to DTO")
    void shouldReturnAllRecords() {
        //given
        given(customRecordRepository.findAll()).willReturn(customRecords);

        //when
        List<CustomRecordDTO> result = customRecordService.getAllCustomRecords();

        //then
        assertAll(
                () -> assertThat(result.size(), equalTo(customRecords.size())),
                () -> assertThat(result.get(0), not(hasProperty("id"))),
                () -> assertThat(result.get(1).getDescription(), equalTo("Walking on the hands")));
    }

    @Test
    @DisplayName("Check if return record by desc")
    void shouldReturnRecord() {
        //given
        given(customRecordRepository.findByDescription("Powerlifting championship")).willReturn(java.util.Optional.ofNullable(recordI));

        //when
        CustomRecordDTO result = customRecordService.getCustomRecord("Powerlifting championship");

        //then
        assertAll(
                () -> assertThat(result.getDescription(), equalTo(recordI.getDescription())),
                () -> assertThat(result.getValue(), equalTo(recordI.getValue()))
        );
    }

    @Test
    @DisplayName("Check if exception is thrown when description is incorrect")
    void shouldThrowAnExceptionIfDescriptionIsIncorrect() {
        //given + when
        given(customRecordRepository.findByDescription("Scuba diving")).willThrow(EntityNotFoundException.class);

        //then
        assertThrows(EntityNotFoundException.class,
                () -> customRecordService.getCustomRecord("Scuba diving"));
    }

    @Test
    @DisplayName("Check if new record is created")
    void shouldCreateNewCustomRecord() {
        //given
        CustomRecordDTO record = new CustomRecordDTO("Horizontal jump", 3, current);

        given(customRecordRepository.existsByDescription("Horizontal jump")).willReturn(false);

        //when
        CustomRecordDTO result = customRecordService.createNewRecord(new CustomRecordDTO("Horizontal jump", 3, current));


        //then
        assertAll(
                () -> verify(customRecordRepository, times(1)).save(ArgumentMatchers.any()),
                () -> assertThat(result.getDescription(), equalTo("Horizontal jump")),
                () -> assertThat(result.getSetDate(), equalTo(current)));
    }

    @Test
    @DisplayName("Check if exception is thrown when description is incorrect")
    void shouldThrowAnExceptionWhenRecordAlreadyExists() {
        //given + when
        given(customRecordRepository.existsByDescription("Base-jumping")).willReturn(true);

        //then
        assertThrows(EntityAlreadyFoundException.class,
                () -> customRecordService.createNewRecord(new CustomRecordDTO("Base-jumping", 12.0, current)));
    }

    @Test
    @DisplayName("Check if record is deleted")
    void shouldDeleteRecordWhenExist() {
        //given
        given(customRecordRepository.existsByDescription("Unfair record")).willReturn(true);

        //when
        customRecordService.deleteCustomRecord("Unfair record");

        //then
        verify(customRecordRepository, times(1)).deleteByDescription("Unfair record");
    }

    @Test
    @DisplayName("Check if exception is thrown when trying to delete inexistent record")
    void shouldThrowAnExceptionWhenRecordDoesnotExist() {
        //given + when
        given(customRecordRepository.existsByDescription("Walk 100m")).willReturn(false);

        //then
        assertThrows(EntityNotFoundException.class, () ->
                customRecordService.deleteCustomRecord("Walk 100m"));
    }

}