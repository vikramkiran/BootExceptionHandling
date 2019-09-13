package com.app.product.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.product.controller.NoProductFoundException;

@ControllerAdvice
@RestController
public class ProductExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handle(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false).toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoProductFoundException.class)
	public final ResponseEntity<Object> handleMyException(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();

		exceptionResponse.setDate(new Date());
		exceptionResponse.setMessage("No there is no product");
		exceptionResponse.setStatus("No...........");
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
