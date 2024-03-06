package com.example.crud.Exception;

import com.example.crud.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(MethodArgumentNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(String.valueOf(exception.getStatusCode().value()));
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, BAD_REQUEST);
    }

    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(String.valueOf(exception.statusCode));
        errorResponse.setMessage(exception.message);
        return new ResponseEntity<>(errorResponse, NOT_FOUND);

    }
    @ExceptionHandler({InvalidReadingIntervalException.class})
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(InvalidReadingIntervalException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(String.valueOf(exception.statusCode));
        errorResponse.setMessage(exception.message);
        return new ResponseEntity<>(errorResponse,BAD_REQUEST);

    }
}
