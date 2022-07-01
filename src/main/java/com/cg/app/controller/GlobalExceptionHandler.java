package com.cg.app.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.app.exception.UnauthourizedException;
import com.cg.app.model.CustomErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UnauthourizedException.class)
	public ResponseEntity<CustomErrorResponse> handleEmployeeException(UnauthourizedException ex){
		CustomErrorResponse customResponse=new CustomErrorResponse();
		customResponse.setTimestamp(LocalDateTime.now());
		customResponse.setMessage(ex.getMessage());
		customResponse.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<CustomErrorResponse>(customResponse,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorResponse> handleException(Exception ex){
		CustomErrorResponse customResponse=new CustomErrorResponse();
		customResponse.setTimestamp(LocalDateTime.now());
		customResponse.setMessage(ex.getMessage());
		customResponse.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<CustomErrorResponse>(customResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){
		
		CustomErrorResponse resp=new CustomErrorResponse();
		resp.setTimestamp(LocalDateTime.now());
		resp.setMessage(exp.getBindingResult().getFieldError().getDefaultMessage());
		resp.setStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
