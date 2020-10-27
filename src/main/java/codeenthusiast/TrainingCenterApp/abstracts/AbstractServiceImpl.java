package codeenthusiast.TrainingCenterApp.abstracts;

import codeenthusiast.TrainingCenterApp.mappers.AbstractMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractServiceImpl<E extends AbstractEntity, D extends AbstractDTO> implements AbstractService<E, D> {

    private final AbstractReposiotory<E> reposiotory;

    private final AbstractMapper<E, D> mapper;

    public AbstractServiceImpl(AbstractReposiotory<E> reposiotory, AbstractMapper<E, D> mapper) {
        this.reposiotory = reposiotory;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public D update(Long id, D dto) {
        dto.setId(id);
        E entity = mapper.mapToEntity(dto);
        return mapper.mapToDTO(reposiotory.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public D findById(Long id) {
        E entity = reposiotory.getOne(id);
        return mapper.mapToDTO(entity);
    }

    @Override
    public D save(D dto) {
        E entity = mapper.mapToEntity(dto);
        return mapper.mapToDTO(reposiotory.save(entity));
    }

    @Override
    public void delete(Long id) {
        reposiotory.deleteById(id);
    }

    @Override
    public List<D> getAll() {
        return mapper.mapToDTOs(reposiotory.findAll());
    }
}
