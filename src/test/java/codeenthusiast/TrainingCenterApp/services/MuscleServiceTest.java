package codeenthusiast.TrainingCenterApp.services;

//import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;
//import codeenthusiast.TrainingCenterApp.muscle.MuscleDTO;
//import codeenthusiast.TrainingCenterApp.image.Image;
//import codeenthusiast.TrainingCenterApp.muscle.Muscle;
//import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyFoundException;
//import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
//import codeenthusiast.TrainingCenterApp.muscle.MuscleServiceImpl;
//import codeenthusiast.TrainingCenterApp.muscle.MuscleRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//import org.modelmapper.ModelMapper;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.*;
//
//@MockitoSettings(strictness = Strictness.STRICT_STUBS)
//@ExtendWith(SpringExtension.class)
//class MuscleServiceTest {
//
//    ModelMapper modelMapper;
//
//    Muscle hamstring;
//    Muscle chest;
//
//    MuscleDTO triceps;
//    MuscleDTO glute;
//
//    Image frontImage;
//
//    Image sideImage;
//
//    @Mock
//    MuscleRepository muscleRepository;
//
//    @Mock
//    ImageServiceImpl imageService;
//
//    MuscleServiceImpl muscleServiceImpl;
//
//    @BeforeEach
//    void setUp() {
//
//        modelMapper = new ModelMapper();
//        hamstring = new Muscle("Hamstring", "Hamstring description");
//        chest = new Muscle("Chest", "Chest description");
//        triceps = new MuscleDTO("Triceps", "Triceps description");
//        glute = new MuscleDTO("Glute", "Glute description");
//
//        frontImage = new Image("secret-folder", "front-image");
//        sideImage = new Image("secret-folder", "side-image");
//
//        muscleServiceImpl = new MuscleServiceImpl(muscleRepository, imageService);
//    }
//
//    @Test
//    @DisplayName("Check if entity don't have id and isInjured params")
//    void shouldMapFromMuscleToMuscleDTO() {
//        //given + when
//        MuscleDTO mappedMuscle = muscleServiceImpl.mapToMuscleDTO(chest);
//
//        //then
//        assertAll(
//                () -> assertThat(mappedMuscle, not(hasProperty("id"))),
//                () -> assertThat(mappedMuscle, not(hasProperty("isInjured"))),
//                () -> assertThat(mappedMuscle.getName(), is(chest.getName())));
//    }
//
//    @Test
//    @DisplayName("Check if entity have new properties : id and isInjured")
//    void shouldMapFromMuscleDTOtoMap() {
//        //given + when
//        Muscle mappedMuscle = muscleServiceImpl.mapToMuscle(triceps);
//
//        //then
//        assertAll(
//                () -> assertThat(mappedMuscle, hasProperty("id", nullValue())),
//                () -> assertThat(mappedMuscle.getName(), is(triceps.getName()))
//        );
//    }
//
//    @Test
//    @DisplayName("Check if true when name exist")
//    void shouldReturnTrueIfExistByName() {
//        //given
//        given(muscleRepository.existsByName("Chest")).willReturn(true);
//
//        //when
//        boolean result = muscleServiceImpl.existsByName("Chest");
//
//        //then
//        assertThat(result, is(true));
//    }
//
//    @Test
//    @DisplayName("Check if false when name does not exist")
//    void shouldReturnFalseIfExistByName() {
//        //given
//        given(muscleRepository.existsByName("Biceps")).willReturn(false);
//
//        //when
//        boolean result = muscleServiceImpl.existsByName("Biceps");
//
//        //then
//        assertThat(result, is(false));
//    }
//
//    @Test
//    @DisplayName("Check if true when id exist")
//    void shouldReturnTrueIfExistById() {
//        //given
//        given(muscleRepository.existsById(1L)).willReturn(true);
//
//        //when
//        boolean result = muscleServiceImpl.existsById(1L);
//
//        //then
//        assertThat(result, is(true));
//    }
//
//    @Test
//    @DisplayName("Check if false when id does not exist")
//    void shouldReturnFalseIfExistById() {
//        //given
//        given(muscleRepository.existsById(400L)).willReturn(false);
//
//        //when
//        boolean result = muscleServiceImpl.existsById(400L);
//
//        //then
//        assertThat(result, is(false));
//    }
//
//    @Test
//    @DisplayName("Check if return all muscles in dto format")
//    void shouldReturnAllMusclesInDTOFormat() {
//        //given
//        List<Muscle> muscles = Arrays.asList(chest, hamstring);
//        given(muscleRepository.findAll()).willReturn(muscles);
//
//        //when
//        List<MuscleDTO> result = muscleServiceImpl.getAllMuscles();
//
//        //then
//        assertAll(
//                () -> assertThat(result.size(), equalTo(2)),
//                () -> assertThat(result.get(0).getName(), equalTo("Chest")),
//                () -> assertThat(result.get(1), not(hasProperty("id")))
//        );
//    }
//
//    @Test
//    @DisplayName("Check if return muscleDTO by name if exist")
//    void shouldReturnMuscleDTOById() {
//        //given
//        given(muscleRepository.findById(1L)).willReturn(java.util.Optional.ofNullable(hamstring));
//
//        //when
//        MuscleDTO muscle = muscleServiceImpl.getMuscle(1L);
//
//        //then
//        assertAll(
//                () -> assertThat(muscle.getName(), equalTo("Hamstring")),
//                () -> assertThat(muscle.getDescription(), equalTo("Hamstring description")),
//                () -> assertThat(muscle, not(hasProperty("id")))
//        );
//
//    }
//
//    @Test
//    @DisplayName("Check if exception is thrown when id does not exist")
//    void shouldThrowEntityNotFoundExceptionWhenMealOfGivenIdDoesNotExist() {
//        // given + when
//        given(muscleRepository.findById(500L)).willThrow(EntityNotFoundException.class);
//
//        //then
//        assertThrows(EntityNotFoundException.class, () ->
//                muscleServiceImpl.getMuscle(500L));
//    }
//
//    @Test
//    @DisplayName("Check if return Muscle when name exists")
//    void shouldReturnMuscleIfNameExists() {
//        //given
//        given(muscleRepository.findById(2L))
//                .willReturn(java.util.Optional.ofNullable(hamstring));
//
//        //when
//        Muscle muscle = muscleServiceImpl.getMuscleEntity(2L);
//
//        //then
//        assertAll(
//                () -> assertThat(muscle.getName(), equalTo("Hamstring")),
//                () -> assertThat(muscle.getDescription(), equalTo("Hamstring description")),
//                () -> assertThat(muscle, hasProperty("id"))
//        );
//    }
//
//    @Test
//    @DisplayName("Check if exception is thrown when id does not exist")
//    void shouldThrowEntityNotFoundExceptionWhenMealOfGivenIsNonexistent() {
//        // given + when
//        given(muscleRepository.findById(500L)).willThrow(EntityNotFoundException.class);
//
//        //then
//        assertThrows(EntityNotFoundException.class, () ->
//                muscleServiceImpl.getMuscleEntity(500L));
//    }
//
//    @Test
//    @DisplayName("check if new Muscle with correct Data is created")
//    void shouldCreateNewMuscle() {
//        //given
//        given(muscleRepository.existsByName("Glute")).willReturn(false);
//        Muscle mappedGlute = modelMapper.map(glute, Muscle.class);
//
//        //when
//        MuscleDTO result = muscleServiceImpl.createMuscle(glute);
//
//        //them
//        assertAll(
//                () -> verify(muscleRepository, times(1)).save(any()),
//                () -> assertThat(result.getName(), equalTo(mappedGlute.getName())),
//                () -> assertThat(result.getDescription(), equalTo(mappedGlute.getDescription())),
//                () -> assertThat(result.getImages(), equalTo(mappedGlute.getImages()))
//        );
//    }
//
//    @Test
//    @DisplayName("check if new exception is thrown in when creating new Muscle with existed name")
//    void shouldThrowEntityAlreadyFoundExceptionIfEntityExists() {
//        //given + when
//        given(muscleRepository.existsByName("Glute")).willReturn(true);
//
//        //then
//        assertThrows(EntityAlreadyFoundException.class, () ->
//                muscleServiceImpl.createMuscle(glute));
//    }
//
//    @Test
//    @DisplayName("Check if delete muscle of existent id")
//    void shouldDeleteMuscleOfGivenIdIfExist() {
//        //given
//        given(muscleRepository.existsById(3L)).willReturn(true);
//
//        //when
//        muscleServiceImpl.deleteMuscle(3L);
//
//        //then
//        verify(muscleRepository, times(1)).deleteById(3L);
//    }
//
//    @Test
//    @DisplayName("Check if meal with correct and id is updated by correct data meal")
//    void shouldUpdateMealWhenDataIsCorrect() {
//        //given
//        MuscleDTO calves = new MuscleDTO("Calves", "Calves description");
//        given(muscleRepository.existsById(5L)).willReturn(true);
//        given(muscleRepository.existsByName("Calves")).willReturn(false);
//
//        //when
//        MuscleDTO result = muscleServiceImpl.updateMuscle(5L, calves);
//
//        //then
//        assertAll(
//                () -> verify(muscleRepository, times(1)).save(any()),
//                () -> assertThat(result.getName(), equalTo("Calves")),
//                () -> assertThat(result.getDescription(), equalTo("Calves description")));
//    }
//
//    @Test
//    @DisplayName("Check if exception is thrown when muscle of given id does not exist")
//    void shouldThrownAnExceptionWhenUpdateMealOfInexistentId() {
//        //given + when
//        MuscleDTO calves = new MuscleDTO("Calves", "Calves description");
//        given(muscleRepository.existsById(5L)).willReturn(false);
//
//        //then
//        assertThrows(EntityNotFoundException.class, () ->
//                muscleServiceImpl.updateMuscle(5L, calves));
//    }
//
//    @Test
//    @DisplayName("Check if exception is thrown when update muscle of existent name")
//    void shouldThrowAnExceptionWhenTryToUpdateMuscleToExistentName() {
//        //given + when
//        MuscleDTO calves = new MuscleDTO("Calves", "Calves description");
//        given(muscleRepository.existsById(5L)).willReturn(true);
//        given(muscleRepository.existsByName("Calves")).willReturn(true);
//
//        //then
//        assertThrows(EntityAlreadyFoundException.class, () ->
//                muscleServiceImpl.updateMuscle(5L, calves));
//    }
//
//
//    @Test
//    @DisplayName("Check if added image to muscle")
//    void shouldAddImageToMuscle() {
//        //given
//        given(muscleRepository.findById(1L)).willReturn(java.util.Optional.ofNullable(chest));
//        given(imageService.createNewImage("secret/path")).willReturn(frontImage);
//
//        //when
//        MuscleDTO muscle = muscleServiceImpl.addImageToMuscle(1L, "secret/path");
//
//        //then
//        assertAll(
//                () -> verify(muscleRepository, times(1)).save(any()),
//                () -> assertThat(muscle.getImages().get(0), equalTo(frontImage)));
//    }
//
//    @Test
//    @DisplayName("Check if deleted image to muscle")
//    void shouldRemoveImageFromMuscle() {
//        //given
//        given(muscleRepository.findById(1L)).willReturn(java.util.Optional.ofNullable(hamstring));
//        given(imageService.findByFileUrl("secret/path")).willReturn(frontImage);
//
//        //when
//        muscleServiceImpl.deleteImageFromMuscle(1L, "secret/path");
//
//        //then
//        assertAll(
//                () -> verify(muscleRepository, times(1)).save(any()),
//                () -> assertThat(chest.getImages().size(), equalTo(0)),
//                () -> assertThat(chest.getImages(), not(hasItem(frontImage))));
//    }
//
//    @Test
//    @DisplayName("Check if remove all images from meal")
//    void deleteAllImagesFromMuscle() {
//        //given
//        given(muscleRepository.findById(1L)).willReturn(java.util.Optional.ofNullable(hamstring));
//
//        //when
//        muscleServiceImpl.deleteAllImagesFromMuscle(1L);
//
//        //then
//        assertThat(chest.getImages().size(), equalTo(0));
//    }
//}