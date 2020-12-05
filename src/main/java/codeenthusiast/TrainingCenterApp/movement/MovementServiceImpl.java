package codeenthusiast.TrainingCenterApp.movement;

import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyExistsException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.image.ImageServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;

    private final ImageServiceImpl imageService;

    private final MovementMapper movementMapper;

    public MovementServiceImpl(MovementRepository movementRepository, ImageServiceImpl imageService, MovementMapper movementMapper) {
        this.movementRepository = movementRepository;
        this.imageService = imageService;
        this.movementMapper = movementMapper;
    }


    @Override
    public boolean isExistsById(Long id) {
        if (!movementRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        return true;
    }

    @Override
    public void checkExistenceByName(String name) {

        if (movementRepository.existsByName(name)) {
            throw new EntityAlreadyExistsException(name);
        }
    }

    public Movement findEntityById(Long id) {
        return movementRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id));
    }

    @Override
    public MovementDTO findById(Long id) {
        Movement movement = findEntityById(id);
        return movementMapper.mapToDTO(movement);
    }

    @Override
    public MovementDTO create(MovementDTO dto) {
        checkExistenceByName(dto.getName());
        Movement movement = movementMapper.mapToEntity(dto);
        return save(movement);
    }

    @Override
    public MovementDTO update(Long id, MovementDTO dto) {
        Movement movement = findEntityById(id);
        movement.setName(dto.getName());
        return save(movement);
    }

    @Override
    public MovementDTO save(Movement movement) {
        Movement savedMovement = movementRepository.save(movement);
        return movementMapper.mapToDTO(savedMovement);
    }


    @Override
    public void deleteById(Long id) {
        isExistsById(id);
        movementRepository.deleteById(id);
    }

    @Override
    public MovementDTO addImage(Long id, MultipartFile file) {
        Movement movement = findEntityById(id);
        imageService.createNewImage(file, movement);
        return movementMapper.mapToDTO(movement);
    }

    @Override
    public MovementDTO removeAllImages(Long id) {
        imageService.deleteImagesByMovementId(id);
        return findById(id);

    }


}
