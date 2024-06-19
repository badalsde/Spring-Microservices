package com.hotel.utility;

import com.hotel.exception.HotelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class RestControllerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> ExceptionHandler(Exception exception){
        ErrorInfo error = new ErrorInfo();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setErrorMessage("General.EXCEPTION_MESSAGE");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HotelException.class)
    public ResponseEntity<ErrorInfo> UserExceptionHandler(HotelException exception){
        ErrorInfo error = new ErrorInfo();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
