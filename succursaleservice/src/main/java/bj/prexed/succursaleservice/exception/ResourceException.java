package bj.prexed.succursaleservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceException extends RuntimeException {
    private HttpStatus status = HttpStatus.NOT_FOUND;

    public ResourceException() {
        this("Resource not found!");
    }

    public ResourceException(String entity, String id) {
        this(String.format("%s{id: %d} not found !!!", entity, id));
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String entity, HttpStatus status) {
        this(entity);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
