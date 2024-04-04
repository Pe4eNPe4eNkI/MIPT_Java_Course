package edu.phystech.hw2.contact;

public class InvalidContactFieldException extends RuntimeException {
    private final String fieldName;

    public InvalidContactFieldException(String message) {
        super(message);
        fieldName = message;
    }

    public String getFieldName() {
        return fieldName;
    }
}
