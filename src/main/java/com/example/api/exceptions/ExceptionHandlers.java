package com.example.api.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<?>exceptionHandler(Exception e, WebRequest webRequest){
		String description = e.getLocalizedMessage();
		
		
		if(description == null) {
			description = e.toString();
		}
		ErrorMessage errorMessage = new ErrorMessage(description);
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.BAD_REQUEST);
		
		
		
	}
}
