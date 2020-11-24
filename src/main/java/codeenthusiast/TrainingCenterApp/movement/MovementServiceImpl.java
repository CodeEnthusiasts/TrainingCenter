package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyExistsException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.ImageDTO;
import codeenthusiast.TrainingCenterApp.mappers.MovementMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;

    private final MovementMapper movementMapper;

    public MovementServiceImpl(MovementRepository movementRepository, MovementMapper movementMapper) {
        this.movementRepository = movementRepository;
        this.movementMapper = movementMapper;
    }

    @Override
    public void deleteById(Long id) {
        checkExistence(id);
        movementRepository.deleteById(id);
    }

    @Override
    public void checkExistence(Long id) {
        if (!movementRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void checkExistenceByName(String name) {

        if (movementRepository.existsByName(name)) {
            throw new EntityAlreadyExistsException(name);
        }
    }

    @Override
    public MovementDTO findById(Long id) {
        Movement Movement = movementRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
        return movementMapper.mapToDTO(Movement);
    }

    @Override
    public MovementDTO update(Long id, MovementDTO dto) {
        checkExistence(id);
        dto.setId(id);
        return save(dto);
    }

    @Override
    public MovementDTO create(MovementDTO dto) {
        checkExistenceByName(dto.getName());
        save(dto);
        return dto;
    }

    @Override
    public MovementDTO save(MovementDTO dto) {
        Movement Movement = movementMapper.mapToEntity(dto);
        movementRepository.save(Movement);
        return dto;
    }

    @Override
    public MovementDTO addImage(Long id, ImageDTO image) {
        MovementDTO Movement = findById(id);
        Movement.getImages().add(image);
        return save(Movement);
    }

    @Override
    public List<Long> removeAllImages(Long id) {
        MovementDTO Movement = findById(id);
        List<Long> idList = getIdOfDeletedImages(Movement.getImages());
        Movement.getImages().clear();
        save(Movement);

        return idList;
    }

    @Override
    public List<Long> getIdOfDeletedImages(List<ImageDTO> images) {
        return images.stream()
                .map(AbstractDTO::getId)
                .collect(Collectors.toList());
    }

    public Movement findEntityById(Long movementId) {
        return movementRepository.findById(movementId).orElseThrow(
                () -> new EntityNotFoundException(movementId));
    }
}
