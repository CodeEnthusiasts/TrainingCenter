package codeenthusiast.TrainingCenterApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Long id){
        super("Entity with ID: " + id + " does not exist.");
    }

    public EntityNotFoundException(String name){
        super("Entity with ID: " + name + "does not exist.");
    }
}
