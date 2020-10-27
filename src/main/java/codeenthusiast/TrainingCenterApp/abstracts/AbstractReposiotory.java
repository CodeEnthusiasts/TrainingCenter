package codeenthusiast.TrainingCenterApp.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractReposiotory <E extends AbstractEntity> extends JpaRepository<E , Long> {
}
