package edu.phystech.hw5.exception;

/**
 * @author kzlv4natoly
 */
public class ValidationException extends RuntimeException {
    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }
}
