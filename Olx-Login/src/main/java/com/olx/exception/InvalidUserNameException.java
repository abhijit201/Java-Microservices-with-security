package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class InvalidUserNameException extends RuntimeException {

    private String username;

    public InvalidUserNameException() {

    }

    public InvalidUserNameException(String username) {
        super();
        this.username = username;
    }

    @Override
    public String toString() {
        return "Invalid username : " + username;
    }
}
