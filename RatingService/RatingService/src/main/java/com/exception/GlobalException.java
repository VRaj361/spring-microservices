package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleException(ResourceNotFoundException exception){
		String msg = exception.getMessage();
		ApiResponse apiRes = ApiResponse.builder().msg(msg).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(apiRes, HttpStatus.NOT_FOUND);
		
	}
}
