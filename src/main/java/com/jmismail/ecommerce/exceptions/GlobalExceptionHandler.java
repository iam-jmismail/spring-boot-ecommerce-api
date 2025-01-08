package com.jmismail.ecommerce.exceptions;

import com.jmismail.ecommerce.responses.ErrorResponse;
import com.jmismail.ecommerce.responses.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleMissingRequestBody(HttpMessageNotReadableException ex) {
        String errorMessage = "Request body is missing or improperly formatted";
        return new ResponseEntity<>(new ErrorResponse(errorMessage), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RuntimeException.class)
    public  ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        String result = ex.getMessage();
        System.out.println(result);
        return new ResponseEntity<>(new ErrorResponse(result), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();

        for (FieldError error : result.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }

        // Create and return the error response
        ValidationErrorResponse errorResponse = new ValidationErrorResponse(errorMap);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
