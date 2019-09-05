package br.com.devdojo.handler;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.devdojo.error.ResourceNotFoundDetails;
import br.com.devdojo.error.ResourceNotFoundException;
import br.com.devdojo.error.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler {
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException) {
		 		 
		 ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
				 .newBuilder()
				 .timestamp( new Date().getTime())
		         .title("Resource not found")
		         .detail(rnfException.getMessage())
		         .status(HttpStatus.NOT_FOUND.value())
		         .developerMessage(rnfException.getClass().getName())
		         .build();
		 
		  return new ResponseEntity<>(rnfDetails,HttpStatus.NOT_FOUND);
		}
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<?> handleResourceNotValidException(ResourceNotFoundException manvException) {
		 
		 
		 ValidationErrorDetails rnfDetails = ValidationErrorDetails.Builder
				 .newBuilder()
				 .timestamp( new Date().getTime())
		         .title("Resource not found")
		         .detail(manvException.getMessage())
		         .status(HttpStatus.NOT_FOUND.value())
		         .developerMessage(manvException.getClass().getName())
		         .build();
		 
		  return new ResponseEntity<>(manvException,HttpStatus.NOT_FOUND);
		}

}
