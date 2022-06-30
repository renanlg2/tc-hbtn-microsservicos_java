package com.example.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<NullPointerException> handleNullPointerException(NullPointerException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value());
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticException> handleArithmeticException(ArithmeticException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value());
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<MissingServletRequestParameterException> handleMissingServletRequestParameterException(MissingServletRequestParameterException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value());
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer, HttpStatus.BAD_REQUEST);
    }
}
