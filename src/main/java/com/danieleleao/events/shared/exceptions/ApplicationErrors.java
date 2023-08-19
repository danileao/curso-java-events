package com.danieleleao.events.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApplicationErrors {

    private String message;
    private int status;
    private LocalDateTime timestamp;
}
