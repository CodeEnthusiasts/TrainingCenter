package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.movement.Movement;
import codeenthusiast.TrainingCenterApp.muscle.Muscle;
import codeenthusiast.TrainingCenterApp.user.major.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image extends AbstractEntity {

    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "muscle_id")
    @JsonIgnore
    private Muscle muscle;

    @ManyToOne
    @JoinColumn(name = "movement_id")
    @JsonIgnore
    private Movement movement;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
