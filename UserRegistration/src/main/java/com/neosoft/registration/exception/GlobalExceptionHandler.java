package com.neosoft.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * The Class GlobalExceptionHandler.
 * 
 * @author Santoshi Yadav
 * 
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * Invalid user id exception.
	 *
	 * @param ex the exception
	 * @return the response entity
	 */
	@ExceptionHandler(InvalidUserIdException.class)
	public ResponseEntity<Object> invalidUserIdException(InvalidUserIdException ex) {
		return new ResponseEntity<Object>("Invalid User Id", HttpStatus.NOT_FOUND);
	}

	/**
	 * Registration failed exception.
	 *
	 * @param ex the exception
	 * @return the response entity
	 */
	@ExceptionHandler(RegistrationFailedException.class)
	public ResponseEntity<Object> registrationFailedException(RegistrationFailedException ex) {
		return new ResponseEntity<Object>("Registration Failed", HttpStatus.NOT_FOUND);
	}

	/**
	 * Invalid email id exception.
	 *
	 * @param ex the exception
	 * @return the response entity
	 */
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Object> invalidEmailIdException(InvalidInputException ex) {
		return new ResponseEntity<Object>("Invalid Input Exception", HttpStatus.BAD_REQUEST);
	}

}
