package com.example.tasklist.controller;

import com.example.tasklist.model.exception.AccessDeniedException;
import com.example.tasklist.model.exception.ExceptionBody;
import com.example.tasklist.model.exception.ImageUploadException;
import com.example.tasklist.model.exception.ResourceMappingException;
import com.example.tasklist.model.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionBody handleResourceNotFound(final ResourceNotFoundException e) {
        return new ExceptionBody(e.getMessage());
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResourceMappingException.class)
    public ExceptionBody handleResourceMapping(final ResourceMappingException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public ExceptionBody handleIllegalState(final IllegalStateException e) {
        return new ExceptionBody(e.getMessage());
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({AccessDeniedException.class,
            org.springframework.security.access.AccessDeniedException.class})
    public ExceptionBody handleAccessDenied() {
        return new ExceptionBody("Access denied.");
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionBody handleMethodArgumentNotValid(final MethodArgumentNotValidException e) {
        ExceptionBody exceptionBody = new ExceptionBody("Validation failed.");
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        exceptionBody.setErrors(errors.stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
        return exceptionBody;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionBody handleConstraintViolation(final ConstraintViolationException e) {
        ExceptionBody exceptionBody = new ExceptionBody("Validation failed.");
        exceptionBody.setErrors(e.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(), ConstraintViolation::getMessage)));
        return exceptionBody;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthenticationException.class)
    public ExceptionBody handleAuthentication(final AuthenticationException e) {
        return new ExceptionBody("Authentication failed.");
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ImageUploadException.class)
    public ExceptionBody handleImageUpload(final ImageUploadException e) {
        return new ExceptionBody(e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleException(final Exception e) {
        e.printStackTrace();
        return new ExceptionBody("Internal error.");
    }
}
