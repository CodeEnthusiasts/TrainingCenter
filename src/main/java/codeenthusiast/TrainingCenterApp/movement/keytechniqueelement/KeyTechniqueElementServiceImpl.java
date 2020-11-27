package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementService;
import org.springframework.stereotype.Service;

@Service
public class KeyTechniqueElementServiceImpl implements KeyTechniqueElementService {

    private final KeyTechniqueElementsRepository repository;
    private final MovementService movementService;
    private final KeyTechniqueElementMapper mapper;

    public KeyTechniqueElementServiceImpl(KeyTechniqueElementsRepository repository,
                                          MovementService movementService, KeyTechniqueElementMapper mapper) {
        this.repository = repository;
        this.movementService = movementService;
        this.mapper = mapper;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public KeyTechniqueElementDTO findById(Long id) {
        KeyTechniqueElement kte = repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(id));
        return mapper.mapToDTO(kte);
    }

    @Override
    public KeyTechniqueElementDTO update(Long id, KeyTechniqueElementDTO dto) {
        dto.setId(id);
        return save(dto);
    }

    @Override
    public KeyTechniqueElementDTO create(Long id, KeyTechniqueElementDTO dto) {
       KeyTechniqueElement kte = new KeyTechniqueElement(dto);
       Movement movement = movementService.findEntityById(id);
       kte.setMovement(movement);
       return save(mapper.mapToDTO(kte));
    }

    @Override
    public KeyTechniqueElementDTO save(KeyTechniqueElementDTO dto) {
        KeyTechniqueElement kte = mapper.mapToEntity(dto);
        repository.save(kte);
        return dto;
    }

}
