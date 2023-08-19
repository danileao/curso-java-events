package com.danieleleao.events.shared.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerHandleException {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handle(CustomException exception) {
        var applicationErrors = new ApplicationErrors(exception.getMessage(), exception.getStatus().value(),
                LocalDateTime.now());
        return new ResponseEntity<>(applicationErrors, exception.getStatus());
    }
}
