package com.example.tasklist.model.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(final String message) {
        super(message);
    }

}
