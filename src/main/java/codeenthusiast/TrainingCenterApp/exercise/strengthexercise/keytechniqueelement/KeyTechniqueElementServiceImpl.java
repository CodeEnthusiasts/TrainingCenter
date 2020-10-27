package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractRepository;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractMapper;
import codeenthusiast.TrainingCenterApp.mappers.KeyTechniqueElementMapper;

public class KeyTechniqueElementServiceImpl extends AbstractServiceImpl<KeyTechniqueElement, KeyTechniqueElementDTO>
                                            implements KeyTechniqueElementService {

    private final KeyTechniqueElementsRepository repository;

    private final KeyTechniqueElementMapper mapper;

    public KeyTechniqueElementServiceImpl(AbstractRepository<KeyTechniqueElement> repository, AbstractMapper<KeyTechniqueElement, KeyTechniqueElementDTO> mapper, KeyTechniqueElementsRepository repository1, KeyTechniqueElementMapper mapper1) {
        super(repository, mapper);
        this.repository = repository1;
        this.mapper = mapper1;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByContent(String name) {
        return repository.existsByContent(name);
    }
}
