package com.ankita.ems.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ankita.ems.exception.RecordNotFoundException;
import com.ankita.ems.model.ErrorResponse;

/**
 * 
 * Exception handler to return customized message
 *
 */
@RestControllerAdvice
public class RestExceptionHandler {

	/**
	 * Handling the record or data not found case
	 * 
	 * @param ex
	 * @return Bad request with customized message
	 */
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> recordNotFound(RecordNotFoundException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), new Date()), HttpStatus.BAD_REQUEST);
	}
}
