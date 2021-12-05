package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class InvalidAuthTokenException extends RuntimeException {

    @Override
    public String toString() {
        return "Invalid Auth Token.";
    }
}
