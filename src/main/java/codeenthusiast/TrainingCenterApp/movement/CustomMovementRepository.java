package codeenthusiast.TrainingCenterApp.movement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomMovementRepository extends JpaRepository<CustomMovement, Long> {
}
