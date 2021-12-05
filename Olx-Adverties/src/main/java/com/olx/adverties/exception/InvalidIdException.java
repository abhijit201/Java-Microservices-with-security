package com.olx.adverties.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidIdException extends RuntimeException {
	private String message;

	public InvalidIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidIdException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid Id :"+message;
	}
}
