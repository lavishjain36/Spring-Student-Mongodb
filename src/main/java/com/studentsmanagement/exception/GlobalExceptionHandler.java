package com.studentsmanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//it works like cental exception handler for all controllers that is created controller layer
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlestudentnotfound(StudentNotFoundException ex){
        Map<String,String> response=new HashMap<>();
        response.put("error",ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);//404
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGlobalException(Exception ex){
        Map<String,String> response=new HashMap<>();
        response.put("error,An unexpected occured ",ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);//500 internal
    }
}
