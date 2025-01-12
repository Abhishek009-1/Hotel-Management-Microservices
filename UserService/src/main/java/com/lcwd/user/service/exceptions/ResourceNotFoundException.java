package com.lcwd.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Resource not found on server side!!");
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
