package com.crg.exceptions;

import com.crg.model.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.util.Date;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(UsernameNotUniqueException.class)
    public ResponseEntity<ApiErrorResponse> handleUsernameNotUniqueException(UsernameNotUniqueException exception) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .timestamp(new Timestamp(new Date().getTime()).toString())
                .error("Conflict")
                .status(HttpStatus.CONFLICT.value())
                .message(exception.getMessage())
                .build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .timestamp(new Timestamp(new Date().getTime()).toString())
                .error("Unprocessable entity")
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .message(exception.getBindingResult().getModel().toString())
                .build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}