package bj.prexed.rhumaineservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {

        this("Resource not found!");
    }

    public ResourceNotFoundException(String entity, Long id) {

        this(String.format(
                "%s{id: %d} not found !!!"
                , entity
                , id));

    }

    private ResourceNotFoundException(String message) {

        super(message);
    }
}
