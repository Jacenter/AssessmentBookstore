package com.example.bookstoreapi.handler;

import com.example.bookstoreapi.error.ValidationError;
import com.example.bookstoreapi.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe) {
        ValidationError validationError = new ValidationError();
        validationError.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        validationError.setMessage(rnfe.getMessage());
        return new ResponseEntity<>(validationError, HttpStatus.NOT_FOUND);
    }
}
