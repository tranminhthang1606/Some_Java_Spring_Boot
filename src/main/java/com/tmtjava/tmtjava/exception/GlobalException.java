package com.tmtjava.tmtjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.tmtjava.tmtjava.dto.ApiResponse;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleRuntimeException(RuntimeException ex) {
        ApiResponse<String> response = new ApiResponse<>(
            ex.getMessage(), 
            HttpStatus.BAD_REQUEST.value(), 
            "ERROR"
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleValidationException(MethodArgumentNotValidException ex) {
        // Lấy validation error đầu tiên
        String fieldError = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        
        ApiResponse<String> response = new ApiResponse<>(
            fieldError, 
            HttpStatus.BAD_REQUEST.value(), 
            "ERROR"
        );
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
