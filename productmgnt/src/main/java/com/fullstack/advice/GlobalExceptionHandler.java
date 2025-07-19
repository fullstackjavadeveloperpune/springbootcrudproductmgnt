package com.fullstack.advice;

import com.fullstack.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> customExceptionHandler(RecordNotFoundException exception) {

        Map<String, String> map = new HashMap<>();

        map.put("{errors}: ", exception.getMessage());

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
