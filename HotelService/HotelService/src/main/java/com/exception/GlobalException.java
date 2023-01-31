package com.exception;

import com.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<ApiResponse> handleException(ResourceNotFoundException res) {
        String msg = res.getMessage();
        ApiResponse api = ApiResponse.builder().msg(msg).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
    }
}
