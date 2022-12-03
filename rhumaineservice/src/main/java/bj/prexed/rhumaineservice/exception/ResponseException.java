package bj.prexed.rhumaineservice.exception;

import java.util.Date;

public class ResponseException {
    private String message;
    private Date timestamp;
    private String details;

    public ResponseException() {
        super();
        this.timestamp = new Date();
    }

    public ResponseException(String message) {
        this();
        this.message = message;
    }

    public ResponseException(String message, String details) {
        this();
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String toString() {
        return String.format("RestError[timestamp: %s, message: %s, details: [%s]]", this.timestamp, this.message, this.details);
    }

}
