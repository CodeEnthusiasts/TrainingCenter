package codeenthusiast.TrainingCenterApp.abstracts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class AbstractServiceImplTest<ENTITY extends AbstractEntity, DTO extends AbstractDTO> {

    abstract AbstractServiceImpl<ENTITY, DTO> getService();

    abstract AbstractRepository<ENTITY> getRepository();

    abstract AbstractMapper<ENTITY, DTO> getMapper();

    abstract Class<DTO> getDTOClass();

    abstract Class<ENTITY> getEntityClass();

    @Captor
    ArgumentCaptor<DTO> dtoCaptor;

    @Test
    @DisplayName("Check if a search by id returns DTO, and execute mapping")
    public void shouldExecuteMappingAndReturnDTO() {
        //given
        ENTITY returnedEntity = mock(getEntityClass());
        DTO mappedDTO = mock(getDTOClass());
        when(getRepository().getOne(1L)).thenReturn(returnedEntity);
        when(getMapper().mapToDTO(returnedEntity)).thenReturn(mappedDTO);

        //when
        DTO result = getService().findById(1L);

        //then
        verify(getRepository()).findById(1L);
        verify(getMapper()).mapToDTO(returnedEntity);
        assertThat(result).isEqualTo(mappedDTO);
    }

    @Test
    @DisplayName("Check if get all entities, mapped to DTO ")
    public void shouldReturnAllEntitiesAndMapToDTO() {
        //given
        List<ENTITY> returnedEntities = Arrays.asList(
                mock(getEntityClass()),
                mock(getEntityClass()));
        List<DTO> returnedDTOs = Arrays.asList(
                mock(getDTOClass()),
                mock(getDTOClass()));
        when(getRepository().findAll()).thenReturn(returnedEntities);
        when(getMapper().mapToDTOs(returnedEntities)).thenReturn(returnedDTOs);

        //when
        List<DTO> result = getService().getAll();

        //then
        verify(getRepository()).findAll();
        verify(getMapper()).mapToDTOs(returnedEntities);
        assertThat(result).isEqualTo(returnedDTOs);
    }

    @Test
    @DisplayName("check if saved and mapped to DTO")
    public void shouldSaveEntityAndReturnMappedEntity() {
        //given
        DTO inputDTO = mock(getDTOClass());
        DTO returnedDTO = mock(getDTOClass());
        ENTITY mappedEntity = mock(getEntityClass());
        ENTITY savedEntity = mock(getEntityClass());
        when(getMapper().mapToEntity(inputDTO)).thenReturn(mappedEntity);
        when(getRepository().save(mappedEntity)).thenReturn(savedEntity);
        when(getMapper().mapToDTO(savedEntity)).thenReturn(returnedDTO);

        //when
        DTO result = getService().save(inputDTO);

        //then
        verify(getMapper()).mapToEntity(inputDTO);
        verify(getRepository()).save(mappedEntity);
        verify(getMapper()).mapToDTO(savedEntity);
        assertThat(result).isEqualTo(returnedDTO);
    }

    @Test
    @DisplayName("Check if save updated entity and return DTO")
    public void shouldSaveEntityAndReturnDTO() {
        //given
        DTO inputDTO = mock(getDTOClass());
        DTO returnedDTO = mock(getDTOClass());
        ENTITY savedEntity = mock(getEntityClass());
        when(getMapper().mapToEntity(inputDTO)).thenReturn(savedEntity);
        when(getRepository().save(savedEntity)).thenReturn(savedEntity);
        when(getMapper().mapToDTO(savedEntity)).thenReturn(returnedDTO);

        //when
        DTO result = getService().update(1L, inputDTO);

        //then
        verify(inputDTO).setId(1L);
        verify(getMapper()).mapToEntity(dtoCaptor.capture());
        verify(getRepository()).save(savedEntity);
        verify(getMapper()).mapToDTO(savedEntity);
        assertThat(result).isEqualTo(returnedDTO);

    }

    @Test
    @DisplayName("Check if deleted by id")
    public void shouldDeleteById() {
        //given + when
        getRepository().deleteById(1L);

        //then
        verify(getRepository()).deleteById(1L);
    }

}
