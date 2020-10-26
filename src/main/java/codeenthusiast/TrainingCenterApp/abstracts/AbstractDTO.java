package codeenthusiast.TrainingCenterApp.abstracts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractDTO {

    private Long id;
}
