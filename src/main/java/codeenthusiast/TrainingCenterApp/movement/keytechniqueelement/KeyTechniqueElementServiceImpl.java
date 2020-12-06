package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.movement.MovementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KeyTechniqueElementServiceImpl implements KeyTechniqueElementService {

    private final KeyTechniqueElementsRepository keyTechniqueElementsRepository;
    private final MovementService movementService;
    private final KeyTechniqueElementMapper keyTechniqueElementMapper;

    public KeyTechniqueElementServiceImpl(KeyTechniqueElementsRepository repository,
                                          MovementService movementService, KeyTechniqueElementMapper mapper) {
        this.keyTechniqueElementsRepository = repository;
        this.movementService = movementService;
        this.keyTechniqueElementMapper = mapper;
    }

    @Override
    public KeyTechniqueElement findEntityById(Long id){
        return keyTechniqueElementsRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(id));
    }

    @Override
    public KeyTechniqueElementDTO findById(Long id) {
        KeyTechniqueElement kte = findEntityById(id);
        return keyTechniqueElementMapper.mapToDTO(kte);
    }

    public List<KeyTechniqueElementDTO> findAllByMovementId(Long movementId) {
        List<KeyTechniqueElement> keyTechniqueElementList =
                keyTechniqueElementsRepository.findAllByMovementId(movementId);
        return keyTechniqueElementMapper.mapToEntities(keyTechniqueElementList);
    }

    @Override
    @Transactional
    public KeyTechniqueElementDTO update(Long id, KeyTechniqueElementDTO dto) {
        KeyTechniqueElement keyTechniqueElement = findEntityById(id);
        keyTechniqueElement.setContent(dto.getContent());
        return save(keyTechniqueElement);
    }

    @Override
    @Transactional
    public KeyTechniqueElementDTO create(Long id, KeyTechniqueElementDTO dto) {
       KeyTechniqueElement kte = new KeyTechniqueElement(dto);
       Movement movement = movementService.findEntityById(id);
       kte.setMovement(movement);
       return save(kte);
    }

    @Override
    public KeyTechniqueElementDTO save(KeyTechniqueElement kte) {
        KeyTechniqueElement savedElement = keyTechniqueElementsRepository.save(kte);
        return keyTechniqueElementMapper.mapToDTO(savedElement);
    }

    @Override
    public void deleteById(Long id) {
        keyTechniqueElementsRepository.deleteById(id);
    }

}
