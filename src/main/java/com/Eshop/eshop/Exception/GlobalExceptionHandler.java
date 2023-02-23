package com.Eshop.eshop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =RecordNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceRecordNotFOundException(RecordNotFoundException ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .body(ex.getMessage()).localDateTime(LocalDateTime.now()).build();
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value =RecordAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> resourceRecordalreadyExistException(RecordAlreadyExistException ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .body(ex.getMessage()).localDateTime(LocalDateTime.now()).build();
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
    }

}
