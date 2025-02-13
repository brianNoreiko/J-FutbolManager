package com.example.FutbolManager.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> HandleConstraintViolation(ConstraintViolationException ex, WebRequest webRequest){
        List<String> errors = new ArrayList<>();
        for(ConstraintViolation violation: ex.getConstraintViolations()){
            errors.add(violation.getMessage());
        }
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<>(apiError,new HttpHeaders(), apiError.getHttpStatus());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public  ResponseEntity<Object> HandleConstraintViolation(AlreadyExistException ex, WebRequest webRequest){
        List<String> errors = new ArrayList<>();
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());}

}
