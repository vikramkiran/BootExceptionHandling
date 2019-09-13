package com.app.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoProductFoundException extends RuntimeException {

	public NoProductFoundException(String string) {

		super(string);
	}

}
