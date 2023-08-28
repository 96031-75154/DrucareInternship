package com.customer.app.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> idNotExistException(IdNotFoundException ex){
		return new ResponseEntity<String>("Id is not available", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> orderNotFoundException(OrderNotFoundException ex) {
		return new ResponseEntity<String>("Order details not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidDetailsException.class)
	public ResponseEntity<String> invalidDetailsException(InvalidDetailsException ex) {
		return new ResponseEntity<String>("Invalid details", HttpStatus.NOT_FOUND);
	}
}
