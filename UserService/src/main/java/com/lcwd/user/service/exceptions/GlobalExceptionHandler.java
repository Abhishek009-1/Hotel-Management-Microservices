package com.lcwd.user.service.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.lcwd.user.service.payload.ApiResponse;

// Ensure this class exists under the correct package:
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException( ResourceNotFoundException e ) {
       String message= e.getMessage();
       ApiResponse response= ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
       return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }
}
