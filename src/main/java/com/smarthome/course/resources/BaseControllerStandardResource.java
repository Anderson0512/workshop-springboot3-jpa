package com.smarthome.course.resources;

import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.exception.ResourceNotFoundException;
import com.smarthome.course.exception.StandardErrorException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class BaseControllerStandardResource {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErrorException> resouceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardErrorException errorException = new StandardErrorException(
                Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(errorException);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<StandardErrorException> dataBaseException(BusinessException e, HttpServletRequest request) {
        String error = "DataBase Error";
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        StandardErrorException errorException = new StandardErrorException(
                Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(errorException);
    }
}
