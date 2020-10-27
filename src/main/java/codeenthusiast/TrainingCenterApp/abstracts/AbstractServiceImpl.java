package codeenthusiast.TrainingCenterApp.abstracts;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractServiceImpl<E extends AbstractEntity, D extends AbstractDTO> implements AbstractService<E, D> {

    private final AbstractRepository<E> repository;

    private final AbstractMapper<E, D> mapper;

    public AbstractServiceImpl(AbstractRepository<E> repository, AbstractMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public D update(Long id, D dto) {
        dto.setId(id);
        E entity = mapper.mapToEntity(dto);
        return mapper.mapToDTO(repository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public D findById(Long id) {
        E entity = repository.getOne(id);
        return mapper.mapToDTO(entity);
    }

    @Override
    public D save(D dto) {
        E entity = mapper.mapToEntity(dto);
        return mapper.mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<D> getAll() {
        return mapper.mapToDTOs(repository.findAll());
    }
}
