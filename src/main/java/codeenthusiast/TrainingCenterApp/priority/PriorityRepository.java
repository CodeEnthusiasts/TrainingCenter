package codeenthusiast.TrainingCenterApp.priority;

import codeenthusiast.TrainingCenterApp.priority.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
